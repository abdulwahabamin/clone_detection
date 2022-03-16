        /**
         * Converts a normalized value to a Number object in the value space between absolute minimum and maximum.
         * 
         * @param normalized
         * @return
         */
        @SuppressWarnings("unchecked")
        private T normalizedToValue(double normalized) {
                return (T) numberType.toNumber(absoluteMinValuePrim + normalized * (absoluteMaxValuePrim - absoluteMinValuePrim));
        }

