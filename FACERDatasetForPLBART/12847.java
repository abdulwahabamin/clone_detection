        private Rect getContentRect(PrintAttributes attributes) {
            MediaSize mediaSize = attributes.getMediaSize();

            // Compute the size of the target canvas from the attributes.
            int pageWidth = (int) (((float) mediaSize.getWidthMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);
            int pageHeight = (int) (((float) mediaSize.getHeightMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);

            // Compute the content size from the attributes.
            Margins minMargins = attributes.getMinMargins();
            final int marginLeft = (int) (((float) minMargins.getLeftMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);
            final int marginTop = (int) (((float) minMargins.getTopMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);
            final int marginRight = (int) (((float) minMargins.getRightMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);
            final int marginBottom = (int) (((float) minMargins.getBottomMils() / MILS_PER_INCH)
                    * POINTS_IN_INCH);
            return new Rect(
                    Math.max(marginLeft, mPrintPageMargin),
                    Math.max(marginTop, mPrintPageMargin),
                    pageWidth - Math.max(marginRight, mPrintPageMargin),
                    pageHeight - Math.max(marginBottom, mPrintPageMargin));
        }

