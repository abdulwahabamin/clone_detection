        /**
         * Decides which (if any) thumb is touched by the given x-coordinate.
         * 
         * @param touchX
         *            The x-coordinate of a touch event in screen space.
         * @return The pressed thumb or null if none has been touched.
         */
        private Thumb evalPressedThumb(float touchX) {
                Thumb result = null;
                boolean minThumbPressed = isInThumbRange(touchX, normalizedMinValue);
                boolean maxThumbPressed = isInThumbRange(touchX, normalizedMaxValue);
                if (minThumbPressed && maxThumbPressed) {
                        // if both thumbs are pressed (they lie on top of each other), choose the one with more room to drag. this avoids "stalling" the thumbs in a corner, not being able to drag them apart anymore.
                        result = (touchX / getWidth() > 0.5f) ? Thumb.MIN : Thumb.MAX;
                }
                else if (minThumbPressed) {
                        result = Thumb.MIN;
                }
                else if (maxThumbPressed) {
                        result = Thumb.MAX;
                }
                return result;
        }

