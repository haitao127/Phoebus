/*******************************************************************************
 * Copyright (c) 2015-2016 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.csstudio.display.builder.model.properties;

import java.util.concurrent.CopyOnWriteArrayList;

/** Predefined, named color maps
 *
 *  @author Kay Kasemir
 */
@SuppressWarnings("nls")
public class PredefinedColorMaps
{
    /** Named color map used for pre-defined values */
    public static class Predefined extends ColorMap
    {
        private final String name, description;

        Predefined(final String name, final String description, final int[][] sections) throws IllegalArgumentException
        {
            super(sections);
            this.name = name;
            this.description = description;
        }

        public String getName()
        {
            return name;
        }

        public String getDescription()
        {
            return description;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }

    /** 'Viridis' color map by Eric Firing
     *
     *  <p>Perceptually uniform, best ever color map.
     *  Google "matplotlib viridis".
     */
    // Values obtained via
    //
    // import matplotlib.pyplot as plt
    // map = plt.get_cmap('viridis')
    // for i,c in enumerate(map.colors):
    //     print("{ %4d, %3d, %3d, %3d }," % ( i, c[0]*255, c[1]*255, c[2]*255) )
    public final static Predefined VIRIDIS = new Predefined("VIRIDIS", "Viridis (perceptually uniform)", new int[][]
    {
       {   0,  68,   1,  84 },
       {   1,  68,   2,  85 },
       {   2,  68,   3,  87 },
       {   3,  69,   5,  88 },
       {   4,  69,   6,  90 },
       {   5,  69,   8,  91 },
       {   6,  70,   9,  92 },
       {   7,  70,  11,  94 },
       {   8,  70,  12,  95 },
       {   9,  70,  14,  97 },
       {  10,  71,  15,  98 },
       {  11,  71,  17,  99 },
       {  12,  71,  18, 101 },
       {  13,  71,  20, 102 },
       {  14,  71,  21, 103 },
       {  15,  71,  22, 105 },
       {  16,  71,  24, 106 },
       {  17,  72,  25, 107 },
       {  18,  72,  26, 108 },
       {  19,  72,  28, 110 },
       {  20,  72,  29, 111 },
       {  21,  72,  30, 112 },
       {  22,  72,  32, 113 },
       {  23,  72,  33, 114 },
       {  24,  72,  34, 115 },
       {  25,  72,  35, 116 },
       {  26,  71,  37, 117 },
       {  27,  71,  38, 118 },
       {  28,  71,  39, 119 },
       {  29,  71,  40, 120 },
       {  30,  71,  42, 121 },
       {  31,  71,  43, 122 },
       {  32,  71,  44, 123 },
       {  33,  70,  45, 124 },
       {  34,  70,  47, 124 },
       {  35,  70,  48, 125 },
       {  36,  70,  49, 126 },
       {  37,  69,  50, 127 },
       {  38,  69,  52, 127 },
       {  39,  69,  53, 128 },
       {  40,  69,  54, 129 },
       {  41,  68,  55, 129 },
       {  42,  68,  57, 130 },
       {  43,  67,  58, 131 },
       {  44,  67,  59, 131 },
       {  45,  67,  60, 132 },
       {  46,  66,  61, 132 },
       {  47,  66,  62, 133 },
       {  48,  66,  64, 133 },
       {  49,  65,  65, 134 },
       {  50,  65,  66, 134 },
       {  51,  64,  67, 135 },
       {  52,  64,  68, 135 },
       {  53,  63,  69, 135 },
       {  54,  63,  71, 136 },
       {  55,  62,  72, 136 },
       {  56,  62,  73, 137 },
       {  57,  61,  74, 137 },
       {  58,  61,  75, 137 },
       {  59,  61,  76, 137 },
       {  60,  60,  77, 138 },
       {  61,  60,  78, 138 },
       {  62,  59,  80, 138 },
       {  63,  59,  81, 138 },
       {  64,  58,  82, 139 },
       {  65,  58,  83, 139 },
       {  66,  57,  84, 139 },
       {  67,  57,  85, 139 },
       {  68,  56,  86, 139 },
       {  69,  56,  87, 140 },
       {  70,  55,  88, 140 },
       {  71,  55,  89, 140 },
       {  72,  54,  90, 140 },
       {  73,  54,  91, 140 },
       {  74,  53,  92, 140 },
       {  75,  53,  93, 140 },
       {  76,  52,  94, 141 },
       {  77,  52,  95, 141 },
       {  78,  51,  96, 141 },
       {  79,  51,  97, 141 },
       {  80,  50,  98, 141 },
       {  81,  50,  99, 141 },
       {  82,  49, 100, 141 },
       {  83,  49, 101, 141 },
       {  84,  49, 102, 141 },
       {  85,  48, 103, 141 },
       {  86,  48, 104, 141 },
       {  87,  47, 105, 141 },
       {  88,  47, 106, 141 },
       {  89,  46, 107, 142 },
       {  90,  46, 108, 142 },
       {  91,  46, 109, 142 },
       {  92,  45, 110, 142 },
       {  93,  45, 111, 142 },
       {  94,  44, 112, 142 },
       {  95,  44, 113, 142 },
       {  96,  44, 114, 142 },
       {  97,  43, 115, 142 },
       {  98,  43, 116, 142 },
       {  99,  42, 117, 142 },
       { 100,  42, 118, 142 },
       { 101,  42, 119, 142 },
       { 102,  41, 120, 142 },
       { 103,  41, 121, 142 },
       { 104,  40, 122, 142 },
       { 105,  40, 122, 142 },
       { 106,  40, 123, 142 },
       { 107,  39, 124, 142 },
       { 108,  39, 125, 142 },
       { 109,  39, 126, 142 },
       { 110,  38, 127, 142 },
       { 111,  38, 128, 142 },
       { 112,  38, 129, 142 },
       { 113,  37, 130, 142 },
       { 114,  37, 131, 141 },
       { 115,  36, 132, 141 },
       { 116,  36, 133, 141 },
       { 117,  36, 134, 141 },
       { 118,  35, 135, 141 },
       { 119,  35, 136, 141 },
       { 120,  35, 137, 141 },
       { 121,  34, 137, 141 },
       { 122,  34, 138, 141 },
       { 123,  34, 139, 141 },
       { 124,  33, 140, 141 },
       { 125,  33, 141, 140 },
       { 126,  33, 142, 140 },
       { 127,  32, 143, 140 },
       { 128,  32, 144, 140 },
       { 129,  32, 145, 140 },
       { 130,  31, 146, 140 },
       { 131,  31, 147, 139 },
       { 132,  31, 148, 139 },
       { 133,  31, 149, 139 },
       { 134,  31, 150, 139 },
       { 135,  30, 151, 138 },
       { 136,  30, 152, 138 },
       { 137,  30, 153, 138 },
       { 138,  30, 153, 138 },
       { 139,  30, 154, 137 },
       { 140,  30, 155, 137 },
       { 141,  30, 156, 137 },
       { 142,  30, 157, 136 },
       { 143,  30, 158, 136 },
       { 144,  30, 159, 136 },
       { 145,  30, 160, 135 },
       { 146,  31, 161, 135 },
       { 147,  31, 162, 134 },
       { 148,  31, 163, 134 },
       { 149,  32, 164, 133 },
       { 150,  32, 165, 133 },
       { 151,  33, 166, 133 },
       { 152,  33, 167, 132 },
       { 153,  34, 167, 132 },
       { 154,  35, 168, 131 },
       { 155,  35, 169, 130 },
       { 156,  36, 170, 130 },
       { 157,  37, 171, 129 },
       { 158,  38, 172, 129 },
       { 159,  39, 173, 128 },
       { 160,  40, 174, 127 },
       { 161,  41, 175, 127 },
       { 162,  42, 176, 126 },
       { 163,  43, 177, 125 },
       { 164,  44, 177, 125 },
       { 165,  46, 178, 124 },
       { 166,  47, 179, 123 },
       { 167,  48, 180, 122 },
       { 168,  50, 181, 122 },
       { 169,  51, 182, 121 },
       { 170,  53, 183, 120 },
       { 171,  54, 184, 119 },
       { 172,  56, 185, 118 },
       { 173,  57, 185, 118 },
       { 174,  59, 186, 117 },
       { 175,  61, 187, 116 },
       { 176,  62, 188, 115 },
       { 177,  64, 189, 114 },
       { 178,  66, 190, 113 },
       { 179,  68, 190, 112 },
       { 180,  69, 191, 111 },
       { 181,  71, 192, 110 },
       { 182,  73, 193, 109 },
       { 183,  75, 194, 108 },
       { 184,  77, 194, 107 },
       { 185,  79, 195, 105 },
       { 186,  81, 196, 104 },
       { 187,  83, 197, 103 },
       { 188,  85, 198, 102 },
       { 189,  87, 198, 101 },
       { 190,  89, 199, 100 },
       { 191,  91, 200,  98 },
       { 192,  94, 201,  97 },
       { 193,  96, 201,  96 },
       { 194,  98, 202,  95 },
       { 195, 100, 203,  93 },
       { 196, 103, 204,  92 },
       { 197, 105, 204,  91 },
       { 198, 107, 205,  89 },
       { 199, 109, 206,  88 },
       { 200, 112, 206,  86 },
       { 201, 114, 207,  85 },
       { 202, 116, 208,  84 },
       { 203, 119, 208,  82 },
       { 204, 121, 209,  81 },
       { 205, 124, 210,  79 },
       { 206, 126, 210,  78 },
       { 207, 129, 211,  76 },
       { 208, 131, 211,  75 },
       { 209, 134, 212,  73 },
       { 210, 136, 213,  71 },
       { 211, 139, 213,  70 },
       { 212, 141, 214,  68 },
       { 213, 144, 214,  67 },
       { 214, 146, 215,  65 },
       { 215, 149, 215,  63 },
       { 216, 151, 216,  62 },
       { 217, 154, 216,  60 },
       { 218, 157, 217,  58 },
       { 219, 159, 217,  56 },
       { 220, 162, 218,  55 },
       { 221, 165, 218,  53 },
       { 222, 167, 219,  51 },
       { 223, 170, 219,  50 },
       { 224, 173, 220,  48 },
       { 225, 175, 220,  46 },
       { 226, 178, 221,  44 },
       { 227, 181, 221,  43 },
       { 228, 183, 221,  41 },
       { 229, 186, 222,  39 },
       { 230, 189, 222,  38 },
       { 231, 191, 223,  36 },
       { 232, 194, 223,  34 },
       { 233, 197, 223,  33 },
       { 234, 199, 224,  31 },
       { 235, 202, 224,  30 },
       { 236, 205, 224,  29 },
       { 237, 207, 225,  28 },
       { 238, 210, 225,  27 },
       { 239, 212, 225,  26 },
       { 240, 215, 226,  25 },
       { 241, 218, 226,  24 },
       { 242, 220, 226,  24 },
       { 243, 223, 227,  24 },
       { 244, 225, 227,  24 },
       { 245, 228, 227,  24 },
       { 246, 231, 228,  25 },
       { 247, 233, 228,  25 },
       { 248, 236, 228,  26 },
       { 249, 238, 229,  27 },
       { 250, 241, 229,  28 },
       { 251, 243, 229,  30 },
       { 252, 246, 230,  31 },
       { 253, 248, 230,  33 },
       { 254, 250, 230,  34 },
       { 255, 253, 231,  36 }
    });

    /** 'Magma' color map
     *
     *  <p>Also perceptually uniform, also from matplotlib.
     */
    // import matplotlib.pyplot as plt
    // map = plt.get_cmap('magma')
    // for i,c in enumerate(map.colors):
    //     print("{ %4d, %3d, %3d, %3d }," % ( i, c[0]*255, c[1]*255, c[2]*255) )
    public final static Predefined MAGMA = new Predefined("MAGMA", "Magma (perceptually uniform)", new int[][]
    {
        {    0,   0,   0,   3 },
        {    1,   0,   0,   4 },
        {    2,   0,   0,   6 },
        {    3,   1,   0,   7 },
        {    4,   1,   1,   9 },
        {    5,   1,   1,  11 },
        {    6,   2,   2,  13 },
        {    7,   2,   2,  15 },
        {    8,   3,   3,  17 },
        {    9,   4,   3,  19 },
        {   10,   4,   4,  21 },
        {   11,   5,   4,  23 },
        {   12,   6,   5,  25 },
        {   13,   7,   5,  27 },
        {   14,   8,   6,  29 },
        {   15,   9,   7,  31 },
        {   16,  10,   7,  34 },
        {   17,  11,   8,  36 },
        {   18,  12,   9,  38 },
        {   19,  13,  10,  40 },
        {   20,  14,  10,  42 },
        {   21,  15,  11,  44 },
        {   22,  16,  12,  47 },
        {   23,  17,  12,  49 },
        {   24,  18,  13,  51 },
        {   25,  20,  13,  53 },
        {   26,  21,  14,  56 },
        {   27,  22,  14,  58 },
        {   28,  23,  15,  60 },
        {   29,  24,  15,  63 },
        {   30,  26,  16,  65 },
        {   31,  27,  16,  68 },
        {   32,  28,  16,  70 },
        {   33,  30,  16,  73 },
        {   34,  31,  17,  75 },
        {   35,  32,  17,  77 },
        {   36,  34,  17,  80 },
        {   37,  35,  17,  82 },
        {   38,  37,  17,  85 },
        {   39,  38,  17,  87 },
        {   40,  40,  17,  89 },
        {   41,  42,  17,  92 },
        {   42,  43,  17,  94 },
        {   43,  45,  16,  96 },
        {   44,  47,  16,  98 },
        {   45,  48,  16, 101 },
        {   46,  50,  16, 103 },
        {   47,  52,  16, 104 },
        {   48,  53,  15, 106 },
        {   49,  55,  15, 108 },
        {   50,  57,  15, 110 },
        {   51,  59,  15, 111 },
        {   52,  60,  15, 113 },
        {   53,  62,  15, 114 },
        {   54,  64,  15, 115 },
        {   55,  66,  15, 116 },
        {   56,  67,  15, 117 },
        {   57,  69,  15, 118 },
        {   58,  71,  15, 119 },
        {   59,  72,  16, 120 },
        {   60,  74,  16, 121 },
        {   61,  75,  16, 121 },
        {   62,  77,  17, 122 },
        {   63,  79,  17, 123 },
        {   64,  80,  18, 123 },
        {   65,  82,  18, 124 },
        {   66,  83,  19, 124 },
        {   67,  85,  19, 125 },
        {   68,  87,  20, 125 },
        {   69,  88,  21, 126 },
        {   70,  90,  21, 126 },
        {   71,  91,  22, 126 },
        {   72,  93,  23, 126 },
        {   73,  94,  23, 127 },
        {   74,  96,  24, 127 },
        {   75,  97,  24, 127 },
        {   76,  99,  25, 127 },
        {   77, 101,  26, 128 },
        {   78, 102,  26, 128 },
        {   79, 104,  27, 128 },
        {   80, 105,  28, 128 },
        {   81, 107,  28, 128 },
        {   82, 108,  29, 128 },
        {   83, 110,  30, 129 },
        {   84, 111,  30, 129 },
        {   85, 113,  31, 129 },
        {   86, 115,  31, 129 },
        {   87, 116,  32, 129 },
        {   88, 118,  33, 129 },
        {   89, 119,  33, 129 },
        {   90, 121,  34, 129 },
        {   91, 122,  34, 129 },
        {   92, 124,  35, 129 },
        {   93, 126,  36, 129 },
        {   94, 127,  36, 129 },
        {   95, 129,  37, 129 },
        {   96, 130,  37, 129 },
        {   97, 132,  38, 129 },
        {   98, 133,  38, 129 },
        {   99, 135,  39, 129 },
        {  100, 137,  40, 129 },
        {  101, 138,  40, 129 },
        {  102, 140,  41, 128 },
        {  103, 141,  41, 128 },
        {  104, 143,  42, 128 },
        {  105, 145,  42, 128 },
        {  106, 146,  43, 128 },
        {  107, 148,  43, 128 },
        {  108, 149,  44, 128 },
        {  109, 151,  44, 127 },
        {  110, 153,  45, 127 },
        {  111, 154,  45, 127 },
        {  112, 156,  46, 127 },
        {  113, 158,  46, 126 },
        {  114, 159,  47, 126 },
        {  115, 161,  47, 126 },
        {  116, 163,  48, 126 },
        {  117, 164,  48, 125 },
        {  118, 166,  49, 125 },
        {  119, 167,  49, 125 },
        {  120, 169,  50, 124 },
        {  121, 171,  51, 124 },
        {  122, 172,  51, 123 },
        {  123, 174,  52, 123 },
        {  124, 176,  52, 123 },
        {  125, 177,  53, 122 },
        {  126, 179,  53, 122 },
        {  127, 181,  54, 121 },
        {  128, 182,  54, 121 },
        {  129, 184,  55, 120 },
        {  130, 185,  55, 120 },
        {  131, 187,  56, 119 },
        {  132, 189,  57, 119 },
        {  133, 190,  57, 118 },
        {  134, 192,  58, 117 },
        {  135, 194,  58, 117 },
        {  136, 195,  59, 116 },
        {  137, 197,  60, 116 },
        {  138, 198,  60, 115 },
        {  139, 200,  61, 114 },
        {  140, 202,  62, 114 },
        {  141, 203,  62, 113 },
        {  142, 205,  63, 112 },
        {  143, 206,  64, 112 },
        {  144, 208,  65, 111 },
        {  145, 209,  66, 110 },
        {  146, 211,  66, 109 },
        {  147, 212,  67, 109 },
        {  148, 214,  68, 108 },
        {  149, 215,  69, 107 },
        {  150, 217,  70, 106 },
        {  151, 218,  71, 105 },
        {  152, 220,  72, 105 },
        {  153, 221,  73, 104 },
        {  154, 222,  74, 103 },
        {  155, 224,  75, 102 },
        {  156, 225,  76, 102 },
        {  157, 226,  77, 101 },
        {  158, 228,  78, 100 },
        {  159, 229,  80,  99 },
        {  160, 230,  81,  98 },
        {  161, 231,  82,  98 },
        {  162, 232,  84,  97 },
        {  163, 234,  85,  96 },
        {  164, 235,  86,  96 },
        {  165, 236,  88,  95 },
        {  166, 237,  89,  95 },
        {  167, 238,  91,  94 },
        {  168, 238,  93,  93 },
        {  169, 239,  94,  93 },
        {  170, 240,  96,  93 },
        {  171, 241,  97,  92 },
        {  172, 242,  99,  92 },
        {  173, 243, 101,  92 },
        {  174, 243, 103,  91 },
        {  175, 244, 104,  91 },
        {  176, 245, 106,  91 },
        {  177, 245, 108,  91 },
        {  178, 246, 110,  91 },
        {  179, 246, 112,  91 },
        {  180, 247, 113,  91 },
        {  181, 247, 115,  92 },
        {  182, 248, 117,  92 },
        {  183, 248, 119,  92 },
        {  184, 249, 121,  92 },
        {  185, 249, 123,  93 },
        {  186, 249, 125,  93 },
        {  187, 250, 127,  94 },
        {  188, 250, 128,  94 },
        {  189, 250, 130,  95 },
        {  190, 251, 132,  96 },
        {  191, 251, 134,  96 },
        {  192, 251, 136,  97 },
        {  193, 251, 138,  98 },
        {  194, 252, 140,  99 },
        {  195, 252, 142,  99 },
        {  196, 252, 144, 100 },
        {  197, 252, 146, 101 },
        {  198, 252, 147, 102 },
        {  199, 253, 149, 103 },
        {  200, 253, 151, 104 },
        {  201, 253, 153, 105 },
        {  202, 253, 155, 106 },
        {  203, 253, 157, 107 },
        {  204, 253, 159, 108 },
        {  205, 253, 161, 110 },
        {  206, 253, 162, 111 },
        {  207, 253, 164, 112 },
        {  208, 254, 166, 113 },
        {  209, 254, 168, 115 },
        {  210, 254, 170, 116 },
        {  211, 254, 172, 117 },
        {  212, 254, 174, 118 },
        {  213, 254, 175, 120 },
        {  214, 254, 177, 121 },
        {  215, 254, 179, 123 },
        {  216, 254, 181, 124 },
        {  217, 254, 183, 125 },
        {  218, 254, 185, 127 },
        {  219, 254, 187, 128 },
        {  220, 254, 188, 130 },
        {  221, 254, 190, 131 },
        {  222, 254, 192, 133 },
        {  223, 254, 194, 134 },
        {  224, 254, 196, 136 },
        {  225, 254, 198, 137 },
        {  226, 254, 199, 139 },
        {  227, 254, 201, 141 },
        {  228, 254, 203, 142 },
        {  229, 253, 205, 144 },
        {  230, 253, 207, 146 },
        {  231, 253, 209, 147 },
        {  232, 253, 210, 149 },
        {  233, 253, 212, 151 },
        {  234, 253, 214, 152 },
        {  235, 253, 216, 154 },
        {  236, 253, 218, 156 },
        {  237, 253, 220, 157 },
        {  238, 253, 221, 159 },
        {  239, 253, 223, 161 },
        {  240, 253, 225, 163 },
        {  241, 252, 227, 165 },
        {  242, 252, 229, 166 },
        {  243, 252, 230, 168 },
        {  244, 252, 232, 170 },
        {  245, 252, 234, 172 },
        {  246, 252, 236, 174 },
        {  247, 252, 238, 176 },
        {  248, 252, 240, 177 },
        {  249, 252, 241, 179 },
        {  250, 252, 243, 181 },
        {  251, 252, 245, 183 },
        {  252, 251, 247, 185 },
        {  253, 251, 249, 187 },
        {  254, 251, 250, 189 },
        {  255, 251, 252, 191 }
    });

    public final static Predefined GRAY = new Predefined("GRAY", "Gray Scale", new int[][]
    {
        {   0,   0,   0,   0 },
        { 255, 255, 255, 255 }
    });

    public final static Predefined JET = new Predefined("JET", "Jet", new int[][]
    {
        {   0,   0,   0, 143 },
        {  28,   0,   0, 255 },
        {  93,   0, 255, 255 },
        { 158, 255, 255,   0 },
        { 223, 255,   0,   0 },
        { 255, 128,   0,   0 }
    });

    public final static Predefined SPECTRUM = new Predefined("SPECTRUM", "Color Spectrum", new int[][]
    {
        {   0,   0,   0,   0 },
        {  32, 255,   0, 255 },
        {  64,   0,   0, 255 },
        {  96,   0, 255, 255 },
        { 128,   0, 255,   0 },
        { 160, 255, 255,   0 },
        { 190, 255, 128,   0 },
        { 223, 255,   0,   0 },
        { 255, 255, 255, 255 }
    });

    public final static Predefined HOT = new Predefined("HOT", "Hot", new int[][]
    {
        {   0,  11,   0,   0 },
        {  94, 255,   0,   0 },
        { 190, 255, 255,   0 },
        { 255, 255, 255, 255 }
    });

    public final static Predefined COOL = new Predefined("COOL", "Cool", new int[][]
    {
        {   0,   0, 255, 255 },
        { 255, 255,   0, 255 }
    });

    public final static Predefined SHADED = new Predefined("SHADED", "Shaded", new int[][]
    {
        {   0,   0,   0,   0 },
        { 128, 255,   0,   0 },
        { 255, 255, 255, 255 }
    });


    /** Predefined color maps
     *
     *  <p>Application startup might extend this list,
     *  for example by reading locally defined maps
     *  from preferences.
     */
    public static CopyOnWriteArrayList<Predefined> PREDEFINED = new CopyOnWriteArrayList<>( new Predefined[] { VIRIDIS, GRAY, JET, SPECTRUM, HOT, COOL, SHADED, MAGMA } );
}
