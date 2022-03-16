        /**
         * Converts the given Number value to a normalized double.
         * 
         * @param value
         *            The Number value to normalize.
         * @return The normalized double.
         */
        private double valueToNormalized(T value) {
                if (0 == absoluteMaxValuePrim - absoluteMinValuePrim) {
                        // prevent division by zero, simply return 0.
                        return 0d;
                }
                return (value.doubleValue() - absoluteMinValuePrim) / (absoluteMaxValuePrim - absoluteMinValuePrim);
        }

