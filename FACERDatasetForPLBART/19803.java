        /**
         * Sets normalized max value to value so that 0 <= normalized min value <= value <= 1. The View will get invalidated when calling this method.
         * 
         * @param value
         *            The new normalized max value to set.
         */
        public void setNormalizedMaxValue(double value) {
                normalizedMaxValue = Math.max(0d, Math.min(1d, Math.max(value, normalizedMinValue)));
                invalidate();
        }

