        @Override
        public void run() {
            sort(mSearchResultComparator);
            if (mInStreamingMode) {
                mHandler.postDelayed(mParseNewResults, STREAMING_MODE_REFRESH_DELAY);
            }
        }

