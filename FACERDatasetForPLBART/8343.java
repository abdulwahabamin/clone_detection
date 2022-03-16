        /**
         * {@inheritDoc}
         */
        @Override
        public void onConcurrentAsyncStart() {
            mSearchInProgress = true;
            mAdapter.startStreaming();
        }

