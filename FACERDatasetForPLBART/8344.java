        /**
         * {@inheritDoc}
         */
        @Override
        public void onConcurrentAsyncEnd(boolean cancelled) {
            mSearchInProgress = false;
            mSearchListView.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        mExecutable = null;
                        mAdapter.stopStreaming();
                        mStreamingSearchProgress.setVisibility(View.INVISIBLE);
                        if (mMimeTypeCategories != null && mMimeTypeCategories.size() > 1) {
                            mMimeTypeSpinner.setVisibility(View.VISIBLE);
                        }
                    } catch (Throwable ex) {
                        Log.e(TAG, "onAsyncEnd method fails", ex); //$NON-NLS-1$
                    }
                }
            });
        }

