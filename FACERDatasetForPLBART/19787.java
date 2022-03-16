        /**
         * Sets the currently selected maximum value. The widget will be invalidated and redrawn.
         * 
         * @param value
         *            The Number value to set the maximum value to. Will be clamped to given absolute minimum/maximum range.
         */
        public void setSelectedMaxValue(T value) {
                // in case absoluteMinValue == absoluteMaxValue, avoid division by zero when normalizing.
                if (0 == (absoluteMaxValuePrim - absoluteMinValuePrim)) {
                        setNormalizedMaxValue(1d);
                }
                else {
                        setNormalizedMaxValue(valueToNormalized(value));
                }
        }

