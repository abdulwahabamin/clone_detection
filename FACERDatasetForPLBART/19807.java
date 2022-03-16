        /**
         * Converts screen space x-coordinates into normalized values.
         * 
         * @param screenCoord
         *            The x-coordinate in screen space to convert.
         * @return The normalized value.
         */
        private double screenToNormalized(float screenCoord) {
                int width = getWidth();
                if (width <= 2 * padding) {
                        // prevent division by zero, simply return 0.
                        return 0d;
                }
                else {
                        double result = (screenCoord - padding) / (width - 2 * padding);
                        return Math.min(1d, Math.max(0d, result));
                }
        }

