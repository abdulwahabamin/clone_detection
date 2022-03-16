        /**
         * Registers given listener callback to notify about changed selected values.
         * 
         * @param listener
         *            The listener to notify about changed selected values.
         */
        public void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener<T> listener) {
                this.listener = listener;
        }

