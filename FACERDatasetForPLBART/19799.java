        /**
         * Draws the "normal" resp. "pressed" thumb image on specified x-coordinate.
         * 
         * @param screenCoord
         *            The x-coordinate in screen space where to draw the image.
         * @param pressed
         *            Is the thumb currently in "pressed" state?
         * @param canvas
         *            The canvas to draw upon.
         */
        private void drawThumb(float screenCoord, boolean pressed, Canvas canvas) {
                canvas.drawBitmap(pressed ? thumbPressedImage : thumbImage, screenCoord - thumbHalfWidth, (float) ((0.5f * getHeight()) - thumbHalfHeight), paint);
        }

