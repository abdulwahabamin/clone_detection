        /**
         * Overridden to restore instance state when device orientation changes. This method is called automatically if you assign an id to the RangeSeekBar widget using the {@link #setId(int)} method.
         */
        @Override
        protected void onRestoreInstanceState(Parcelable parcel) {
                final Bundle bundle = (Bundle) parcel;
                super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
                normalizedMinValue = bundle.getDouble("MIN");
                normalizedMaxValue = bundle.getDouble("MAX");
        }

