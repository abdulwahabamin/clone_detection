    /**
     * Method that prints the document as a Pdf
     *
     * @param ctx The current context
     * @param fso The pdf to print
     */
    private static void printPdfDocument(final Context ctx, final FileSystemObject document) {
        PrintManager printManager = (PrintManager) ctx.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        PrintAttributes attr = new PrintAttributes.Builder()
                .setMediaSize(mediaSize)
                .setColorMode(PrintAttributes.COLOR_MODE_COLOR)
                .build();

        String name = String.valueOf(System.currentTimeMillis());
        if (document != null) {
            name = document.getName();
        }
        printManager.print(name, new PrintDocumentAdapter() {
            @Override
            public void onWrite(PageRange[] pages, ParcelFileDescriptor destination,
                    CancellationSignal cancellationSignal, WriteResultCallback callback) {
                FileInputStream fis = null;
                FileOutputStream fos = null;
                AsyncDocumentReader reader = null;

                try {
                    // Try first with java.io before using pipes

                    File file = new File(document.getFullPath());
                    if (file.isFile() && file.canRead()) {
                        fis = new FileInputStream(file);
                    } else {
                        reader = new AsyncDocumentReader(ctx);
                        CommandHelper.read(ctx, document.getFullPath(), reader, null);
                        fis = reader.mIn;
                    }
                    fos = new FileOutputStream(destination.getFileDescriptor());

                    // Write the document
                    int bufferSize = ctx.getResources().getInteger(R.integer.buffer_size);
                    byte[] data = new byte[bufferSize];
                    int read = 0;
                    while ((read = fis.read(data)) > 0) {
                        fos.write(data, 0, read);
                    }

                    // All was ok
                    callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});

                } catch (Exception ex) {
                    // Failed.
                    ExceptionUtil.translateException(ctx, ex);
                    callback.onWriteFailed("Failed to print image");

                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        // Ignore
                    }
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        // Ignore
                    }
                    if (reader != null && reader.mIn != null) {
                        try {
                            reader.mIn.close();
                        } catch (IOException ex) {
                            //Ignore
                        }
                    }
                }
            }

            @Override
            public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
                    CancellationSignal cancellationSignal, LayoutResultCallback callback,
                    Bundle extras) {

                if (cancellationSignal.isCanceled()) {
                    callback.onLayoutCancelled();
                    return;
                }

                String name = String.valueOf(System.currentTimeMillis());
                if (document != null) {
                    name = document.getName();
                }
                PrintDocumentInfo info = new PrintDocumentInfo.Builder(name)
                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                    .build();
                boolean changed = !newAttributes.equals(oldAttributes);
                callback.onLayoutFinished(info, changed);
            }
        }, attr);
    }

