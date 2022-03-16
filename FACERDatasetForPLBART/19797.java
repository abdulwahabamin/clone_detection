        /**
         * Overridden to save instance state when device orientation changes. This method is called automatically if you assign an id to the RangeSeekBar widget using the {@link #setId(int)} method. Other members of this class than the normalized min and max values don't need to be saved.
         */
        @Override
        protected Parcelable onSaveInstanceState() {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("SUPER", super.onSaveInstanceState());
                bundle.putDouble("MIN", normalizedMinValue);
                bundle.putDouble("MAX", normalizedMaxValue);
                return bundle;
        }

