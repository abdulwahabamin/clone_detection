        private void printHeader(Context ctx, Page page, Rect pageContentRect,
                int charsPerRow) {
            String name = String.valueOf(System.currentTimeMillis());
            if (mDocument != null) {
                name = mDocument.getName();
            }
            String header = ctx.getString(R.string.print_document_header, name);
            if (header.length() >= charsPerRow) {
                header = header.substring(header.length() - 3) + "...";
            }
            page.getCanvas().drawText(header,
                    (int) (pageContentRect.width() / 2) - (mPaint.measureText(header) / 2),
                    pageContentRect.top + mTextBounds.height(), mPaint);
        }

