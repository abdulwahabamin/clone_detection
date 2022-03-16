        @Override
        public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
                CancellationSignal cancellationSignal, LayoutResultCallback callback,
                Bundle extras) {

            // Check if document is valid
            if (mReader.getDocumentMode() == 0) {
                callback.onLayoutFailed("Failed to read document");
                return;
            }

            if (cancellationSignal.isCanceled()) {
                callback.onLayoutCancelled();
                return;
            }
            mAttributes = newAttributes;
            Rect pageContentRect = getContentRect(newAttributes);
            int charsPerRow = (int) (pageContentRect.width() / mTextBounds.width());
            int rowsPerPage = rowsPerPage(pageContentRect);
            adjustLines(pageContentRect, charsPerRow);

            String name = String.valueOf(System.currentTimeMillis());
            long size = 0;
            if (mDocument != null) {
                name = mDocument.getName();
                size = mDocument.getSize();
            }
            PrintDocumentInfo info = new PrintDocumentInfo.Builder(name)
                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(calculatePageCount(rowsPerPage))
                .build();
            info.setDataSize(size);
            boolean changed = !newAttributes.equals(oldAttributes);
            callback.onLayoutFinished(info, changed);
        }

