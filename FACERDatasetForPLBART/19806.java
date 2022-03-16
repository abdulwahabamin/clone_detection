        /**
         * Converts a normalized value into screen space.
         * 
         * @param normalizedCoord
         *            The normalized value to convert.
         * @return The converted value in screen space.
         */
        private float normalizedToScreen(double normalizedCoord) {
                return (float) (padding + normalizedCoord * (getWidth() - 2 * padding));
        }

