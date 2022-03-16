    /**
     * Method that prints the document from a string buffer
     *
     * @param ctx The current context
     * @param fso The document to print
     * @param sb The buffer to print
     * @param adjustLines If document must be adjusted
     */
    public static void printStringDocument(final Context ctx, final FileSystemObject document,
            final StringBuilder sb) {
        PrintManager printManager = (PrintManager) ctx.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes attr = new PrintAttributes.Builder()
                .setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT)
                .setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME)
                .build();
        final DocumentAdapterReader reader = new DocumentAdapterReader() {
            @Override
            public void read(List<String> lines, List<String> adjustedLines) {
                BufferedReader br = null;
                try {
                    int bufferSize = ctx.getResources().getInteger(R.integer.buffer_size);
                    br = new BufferedReader(new StringReader(sb.toString()), bufferSize);
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }

                } catch (IOException ex) {
                    Log.e(TAG, "Failed to read file " + document.getFullPath(), ex);
                    lines.clear();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException ex) {
                            // Ignore
                        }
                    }
                }
            }

            @Override
            public int getDocumentMode() {
                // Always is text
                return 1;
            }
        };
        String name = String.valueOf(System.currentTimeMillis());
        if (document != null) {
            name = document.getName();
        }
        printManager.print(name, new DocumentAdapter(ctx, document, reader), attr);
    }

