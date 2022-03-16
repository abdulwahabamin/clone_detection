        private void printFooter(Context ctx, Page page, Rect pageContentRect, int pageNumber) {
            String footer = ctx.getString(R.string.print_document_footer, pageNumber);
            page.getCanvas().drawText(footer,
                    (int) (pageContentRect.width() / 2) - (mPaint.measureText(footer) / 2),
                    pageContentRect.bottom - mTextBounds.height(), mPaint);
        }

