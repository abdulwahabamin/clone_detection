        /**
         * Sets the currently selected minimum value. The widget will be invalidated and redrawn.
         * 
         * @param value
         *            The Number value to set the minimum value to. Will be clamped to given absolute minimum/maximum range.
         */
        public void setSelectedMinValue(T value) {
                // in case absoluteMinValue == absoluteMaxValue, avoid division by zero when normalizing.
                if (0 == (absoluteMaxValuePrim - absoluteMinValuePrim)) {
                        setNormalizedMinValue(0d);
                }
                else {
                        setNormalizedMinValue(valueToNormalized(value));
                }
        }

