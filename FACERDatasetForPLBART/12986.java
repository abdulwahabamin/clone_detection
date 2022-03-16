        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            final int width = getWidth();
            final int height = getHeight();
            if (width == 0 || height == 0) {
                return;
            }

            // Calculate the widget size using the width and height params
            Rect rect = new Rect();
            final int diameter = Math.min(width, height);
            rect.left = (width - diameter) / 2;
            rect.right = rect.left + diameter;
            rect.top = (height - diameter) / 2;
            rect.bottom = rect.top + diameter;
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
            if (!USE_COLORS || mDiskUsage == null || mDiskUsage.getUsageCategoryList().isEmpty()) {
                drawUsed(rect, stroke, used);
            } else {
                drawUsedWithColors(rect, stroke);
            }

            if (used >= mDiskWarningAngle) {
                Toast.makeText(getContext(), sWarningText, Toast.LENGTH_SHORT).show();
            }

        }

