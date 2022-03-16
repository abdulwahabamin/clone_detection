    /**
     * Method that prints the document as an image
     *
     * @param ctx The current context
     * @param fso The image to print
     */
    private static void printImage(final Context ctx, final FileSystemObject image) {
        // Check that the image is supported by Android
        if (isValidImageDocument(image.getFullPath())) {
            DialogHelper.showToast(ctx, R.string.print_unsupported_image, Toast.LENGTH_SHORT);
            return;
        }

        Bitmap bitmap = null;
        AsyncDocumentReader reader = null;
        try {
            // Try first with java.io before using pipes
            File file = new File(image.getFullPath());
            if (file.isFile() && file.canRead()) {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = BitmapFactory.decodeFile(image.getFullPath(), options);
            } else {
                reader = new AsyncDocumentReader(ctx);
                CommandHelper.read(ctx, image.getFullPath(), reader, null);

                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                bitmap = BitmapFactory.decodeStream(reader.mIn);
            }
            if (bitmap == null) {
                throw new IOException("Failed to load image");
            }

        } catch (Exception ex) {
            ExceptionUtil.translateException(ctx, ex);
            return;

        } finally {
            if (reader != null && reader.mIn != null) {
                try {
                    reader.mIn.close();
                } catch (IOException ex) {
                    //Ignore
                }
            }
            if (reader != null && reader.mFdIn != null) {
                try {
                    reader.mFdIn.close();
                } catch (IOException ex) {
                    //Ignore
                }
            }
        }

        final Bitmap fBitmap = bitmap;
        PrintManager printManager = (PrintManager) ctx.getSystemService(Context.PRINT_SERVICE);
        PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
        if (fBitmap.getWidth() > fBitmap.getHeight()) {
            mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        }
        PrintAttributes attr = new PrintAttributes.Builder()
                .setMediaSize(mediaSize)
                .setColorMode(PrintAttributes.COLOR_MODE_COLOR)
                .build();

        String name = String.valueOf(System.currentTimeMillis());
        if (image != null) {
            name = image.getName();
        }
        printManager.print(name, new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;

            @Override
            public void onWrite(PageRange[] pages, ParcelFileDescriptor destination,
                    CancellationSignal cancellationSignal, WriteResultCallback callback) {
                PrintedPdfDocument pdfDocument = new PrintedPdfDocument(ctx,
                        mAttributes);
                try {
                    Page page = pdfDocument.startPage(1);
                    RectF content = new RectF(page.getInfo().getContentRect());
                    Matrix matrix = getMatrix(fBitmap.getWidth(), fBitmap.getHeight(), content);

                    // Draw the bitmap.
                    page.getCanvas().drawBitmap(fBitmap, matrix, null);

                    // Finish the page.
                    pdfDocument.finishPage(page);

                    try {
                        // Write the document
                        pdfDocument.writeTo(new FileOutputStream(destination.getFileDescriptor()));

                        // Done
                        callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } catch (IOException ioe) {
                        // Failed.
                        ExceptionUtil.translateException(ctx, ioe);
                        callback.onWriteFailed("Failed to print image");
                    }
                } finally {
                    if (pdfDocument != null) {
                        pdfDocument.close();
                    }
                    if (destination != null) {
                        try {
                            destination.close();
                        } catch (IOException ioe) {
                            /* ignore */
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
                mAttributes = newAttributes;
                String name = String.valueOf(System.currentTimeMillis());
                if (image != null) {
                    name = image.getName();
                }
                PrintDocumentInfo info = new PrintDocumentInfo.Builder(name)
                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_PHOTO)
                    .setPageCount(1)
                    .build();
                boolean changed = !newAttributes.equals(oldAttributes);
                callback.onLayoutFinished(info, changed);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (fBitmap != null) {
                    fBitmap.recycle();
                }
            }

            private Matrix getMatrix(int imageWidth, int imageHeight, RectF content) {
                Matrix matrix = new Matrix();

                // Compute and apply scale to fill the page.
                float widthRatio = content.width() / imageWidth;
                float heightRatio = content.height() / imageHeight;
                float scale = Math.max(widthRatio, heightRatio);
                matrix.postScale(scale, scale);

                // Center the content.
                final float translateX = (content.width()
                        - imageWidth * scale) / 2;
                final float translateY = (content.height()
                        - imageHeight * scale) / 2;
                matrix.postTranslate(translateX, translateY);
                return matrix;
            }
        }, attr);
    }

