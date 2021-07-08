/*
 * Copyright (C) 2020 European Spallation Source ERIC.
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.phoebus.logbook.olog.ui;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import org.phoebus.framework.jobs.JobManager;
import org.phoebus.framework.util.IOUtils;
import org.phoebus.logbook.Attachment;
import org.phoebus.logbook.olog.ui.write.AttachmentsViewController;
import org.phoebus.ui.dialog.ExceptionDetailsErrorDialog;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for the AttachmentPreview.fxml view. It is designed to be used both
 * by a log entry editor and the read-only log entry details view.
 */
public class AttachmentsPreviewController {

    @FXML
    private SplitPane splitPane;

    @FXML
    private StackPane previewPane;

    @FXML
    private ImageView imagePreview;

    @FXML
    private TextArea textPreview;

    @FXML
    private GridPane noPreviewPane;

    @FXML
    private ListView<Attachment> attachmentListView;

    /**
     * List of attachments selected by user in the preview's {@link ListView}.
     */
    private ObservableList<Attachment> selectedAttachments = FXCollections.observableArrayList();

    /**
     * List of listeners that will be notified when user has selected one or multiple attachments in
     * the {@link ListView}.
     */
    private List<ListChangeListener<Attachment>> listSelectionChangeListeners = new ArrayList<>();


    @FXML
    public void initialize() {

        attachmentListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        attachmentListView.setCellFactory(view -> new AttachmentRow());
        attachmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            /**
             * Shows preview of selected attachment.
             * @param observable
             * @param oldValue
             * @param newValue
             */
            @Override
            public void changed(ObservableValue<? extends Attachment> observable, Attachment oldValue, Attachment newValue) {
                showPreview(newValue);
            }
        });

        attachmentListView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<>() {
            /**
             * Notifies listeners of list selection change.
             * @param change
             */
            @Override
            public void onChanged(Change<? extends Attachment> change) {
                selectedAttachments.setAll(change.getList());
                listSelectionChangeListeners.stream().forEach(l -> l.onChanged(change));
            }
        });

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem = new MenuItem(Messages.DownloadSelected);
        menuItem.setOnAction(actionEvent -> downloadSelectedAttachments());
        menuItem.disableProperty().bind(Bindings.createBooleanBinding(() -> selectedAttachments.isEmpty(), selectedAttachments));
        contextMenu.getItems().add(menuItem);
        attachmentListView.setContextMenu(contextMenu);

        imagePreview.fitWidthProperty().bind(previewPane.widthProperty());
        imagePreview.fitHeightProperty().bind(previewPane.heightProperty());
    }

    public ObservableList<Attachment> getSelectedAttachments() {
        return attachmentListView.getSelectionModel().getSelectedItems();
    }

    /**
     * Sets the list of attachments and installs a listener that selects and subsequently shows the last item
     * in the <code>attachments</code>list.
     *
     * @param attachments List of {@link Attachment}s to show in the preview.
     */
    public void setAttachments(ObservableList<Attachment> attachments) {
        attachmentListView.setItems(attachments);
        attachmentListView.getItems().addListener(new ListChangeListener<>() {
            /**
             * Handles a change in the {@link ListView} such that a newly added item is selected and
             * shown in preview. Note that if multiple attachments are added, this method will be called multiple
             * times, and for each call the current selection is cleared. Consequently the last attachment
             * will end up being selected and shown in preview.
             * @param change
             */
            @Override
            public void onChanged(Change<? extends Attachment> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        attachmentListView.getSelectionModel().clearSelection();
                        attachmentListView.getSelectionModel().select(change.getAddedSubList().get(0));
                    }
                }
            }
        });
    }

    private class AttachmentRow extends ListCell<Attachment> {
        @Override
        public void updateItem(Attachment attachment, boolean empty) {
            super.updateItem(attachment, empty);
            if (empty)
                setText("");
            else {
                setText(attachment.getName());
            }
        }
    }

    /**
     * Shows selected attachment in preview pane.
     *
     * @param attachment
     */
    private void showPreview(Attachment attachment) {
        if (attachment == null) {
            imagePreview.visibleProperty().setValue(false);
            textPreview.visibleProperty().setValue(false);
            return;
        }
        if (attachment.getContentType().startsWith("image")) {
            showImagePreview(attachment);
        } else {
            // Other file types...
            // Need some file content detection here (Apache Tika?) to determine if the file is
            // plain text and thus possible to preview in a TextArea.
            showFilePreview(attachment);
        }
    }

    /**
     * Shows image preview in preview pane. The size of the {@link ImageView} is calculated based on
     * the size of the preview pane and the actual image size such that the complete image is always shown.
     * TODO: Viewing the image in original resolution should be implemented as a separate action, e.g. double
     * click image attachment in list.
     *
     * @param attachment
     */
    private void showImagePreview(Attachment attachment) {
        try {
            BufferedImage bufferedImage = ImageIO.read(attachment.getFile());
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imagePreview.visibleProperty().setValue(true);
            textPreview.visibleProperty().setValue(false);
            imagePreview.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(AttachmentsViewController.class.getName())
                    .log(Level.SEVERE, "Unable to load image file " + attachment.getFile().getAbsolutePath(), ex);
        }
    }

    /**
     * Shows a file attachment that is not an image, e.g. text.
     * TODO: Some kind of file content detection (Apache Tika?) should be used to determine if preview makes sense.
     *
     * @param attachment
     */
    private void showFilePreview(Attachment attachment) {
        imagePreview.visibleProperty().setValue(false);
        noPreviewPane.visibleProperty().setValue(false);
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new FileInputStream(attachment.getFile()), result);
            String content = new String(result.toByteArray());
            textPreview.textProperty().set(content);
            textPreview.visibleProperty().setValue(true);
        } catch (IOException e) {
            Logger.getLogger(AttachmentsViewController.class.getName())
                    .log(Level.SEVERE, "Unable to read file " + attachment.getFile().getAbsolutePath(), e);
        }
    }

    /**
     * Downloads all selected attachments to folder selected by user.
     */
    public void downloadSelectedAttachments() {
        final DirectoryChooser dialog = new DirectoryChooser();
        dialog.setTitle(Messages.SelectFolder);
        dialog.setInitialDirectory(new File(System.getProperty("user.home")));
        File targetFolder = dialog.showDialog(splitPane.getScene().getWindow());
        JobManager.schedule("Save attachments job", (monitor) ->
        {
            selectedAttachments.stream().forEach(a -> downloadAttachment(targetFolder, a));
        });
    }

    private void downloadAttachment(File targetFolder, Attachment attachment) {
        try {
            File targetFile = new File(targetFolder, attachment.getName());
            if (targetFile.exists()) {
                throw new Exception("Target file " + targetFile.getAbsolutePath() + " exists");
            }
            Files.copy(attachment.getFile().toPath(), targetFile.toPath());
        } catch (Exception e) {
            ExceptionDetailsErrorDialog.openError(splitPane.getParent(), Messages.FileSave, Messages.FileSaveFailed, e);
        }
    }

    public void addListSelectionChangeListener(ListChangeListener<Attachment> changeListener) {
        listSelectionChangeListeners.add(changeListener);
    }

    public void removeListSelectionChangeListener(ListChangeListener<Attachment> changeListener) {
        listSelectionChangeListeners.remove(changeListener);
    }
}
