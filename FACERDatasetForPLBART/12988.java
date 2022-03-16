        /**
         * Method that creates the drawing object.
         *
         * @param rect The area of drawing
         * @param color Integer id of the color
         * @param stroke The stroke width
         *
         * @return DrawingObject The drawing object
         *
         * [TODO][MSB]: Implement colors for sections into theme
         */
        @Deprecated
        private DrawingObject createDrawingObjectNoTheme(
                Rect rect, int color, int stroke) {
            DrawingObject out = new DrawingObject();
            out.mSweepAngle = 0;
            out.mPaint.setColor(color);
            out.mPaint.setStrokeWidth(stroke);
            out.mPaint.setAntiAlias(true);
            out.mPaint.setStrokeCap(Paint.Cap.BUTT);
            out.mPaint.setStyle(Paint.Style.STROKE);
            out.mRectF = new RectF(rect);
            return out;
        }

