        /**
         * Decides if given x-coordinate in screen space needs to be interpreted as "within" the normalized thumb x-coordinate.
         * 
         * @param touchX
         *            The x-coordinate in screen space to check.
         * @param normalizedThumbValue
         *            The normalized x-coordinate of the thumb to check.
         * @return true if x-coordinate is in thumb range, false otherwise.
         */
        private boolean isInThumbRange(float touchX, double normalizedThumbValue) {
                return Math.abs(touchX - normalizedToScreen(normalizedThumbValue)) <= thumbHalfWidth;
        }

