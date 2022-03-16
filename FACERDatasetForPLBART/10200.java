        /**
         * Method that creates the drawing object.
         *
         * @param rect The area of drawing
         * @param colorResourceThemeId The theme resource identifier of the color
         * @param stroke The stroke width
         *
         * @return DrawingObject The drawing object
         */
        private DrawingObject createDrawingObject(
                Rect rect, String colorResourceThemeId, int stroke) {
            DrawingObject out = new DrawingObject();
            out.mSweepAngle = 0;
            Theme theme = ThemeManager.getCurrentTheme(getContext());
            out.mPaint.setColor(theme.getColor(getContext(), colorResourceThemeId));
            out.mPaint.setStrokeWidth(stroke);
            out.mPaint.setAntiAlias(true);
            out.mPaint.setStrokeCap(Paint.Cap.BUTT);
            out.mPaint.setStyle(Paint.Style.STROKE);
            out.mRectF = new RectF(rect);
            return out;
        }

