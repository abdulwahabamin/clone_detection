        /**
         * Sets normalized min value to value so that 0 <= value <= normalized max value <= 1. The View will get invalidated when calling this method.
         * 
         * @param value
         *            The new normalized min value to set.
         */
        public void setNormalizedMinValue(double value) {
                normalizedMinValue = Math.max(0d, Math.min(1d, Math.min(value, normalizedMaxValue)));
                invalidate();
        }

