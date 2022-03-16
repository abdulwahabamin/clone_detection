        /**
         * {@inheritDoc}
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            this.mStart = start;
            this.mCount = count;
        }

