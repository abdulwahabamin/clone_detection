        /**
         * Ensures correct size of the widget.
         */
        @Override
        protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int width = 200;
                if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(widthMeasureSpec)) {
                        width = MeasureSpec.getSize(widthMeasureSpec);
                }
                int height = thumbImage.getHeight();
                if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(heightMeasureSpec)) {
                        height = Math.min(height, MeasureSpec.getSize(heightMeasureSpec));
                }
                setMeasuredDimension(width, height);
        }

