    /**
     * Method that prints the document as a text document
     *
     * @param ctx The current context
     * @param fso The document to print
     */
    private static void printTextDocument(final Context ctx, final FileSystemObject document) {
        PrintManager printManager = (PrintManager) ctx.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes attr = new PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT)
                .setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
                .build();
        final DocumentAdapterReader reader = new DocumentAdapterReader() {
            private int mDocumentMode = -1;

            @Override
            public void read(List<String> lines, List<String> adjustedLines) {
                mDocumentMode = getDocumentMode();
                if (mDocumentMode <= 0) {
                    lines.clear();
                } else if (mDocumentMode == 2) {
                    adjustedLines.addAll(readHexDumpDocumentFile(ctx, document, lines));
                } else {
                    readDocumentFile(ctx, document, lines);
                }
            }

            @Override
            public int getDocumentMode() {
                if (mDocumentMode == -1) {
                    String mimeType = MimeTypeHelper.getMimeType(ctx, document);
                    if (mimeType == null) {
                        mDocumentMode = 0; // Invalid
                    } else {
                        mDocumentMode = isBinaryDocument(ctx, document) ? 2 : 1; // binary / text
                    }
                }
                return mDocumentMode;
            }
        };
        String name = String.valueOf(System.currentTimeMillis());
        if (document != null) {
            name = document.getName();
        }
        printManager.print(name, new DocumentAdapter(ctx, document, reader), attr);
    }

