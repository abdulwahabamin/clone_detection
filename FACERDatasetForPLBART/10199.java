        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            //Get information about the drawing zone, and adjust the size
            Rect rect = new Rect();
            getDrawingRect(rect);
            int stroke = (rect.width() / 2) / 2;
            rect.left += stroke / 2;
            rect.right -= stroke / 2;
            rect.top += stroke / 2;
            rect.bottom -= stroke / 2;

            float used = 100.0f;
            if (this.mDiskUsage != null && this.mDiskUsage.getTotal() != 0) {
                used = (this.mDiskUsage.getUsed() * 100) / this.mDiskUsage.getTotal();
            }
            //Translate to angle
            used = (360 * used) / 100;

            // Draws out the graph background color
            drawTotal(rect, stroke);

            // Draw the usage
            if (USE_COLORS) {
                drawUsedWithColors(rect, stroke);
            } else {
                drawUsed(rect, stroke, used);
            }

            if (used >= mDiskWarningAngle) {
                Toast.makeText(getContext(), sWarningText, Toast.LENGTH_SHORT).show();
            }

        }

