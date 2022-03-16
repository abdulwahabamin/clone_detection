    /**
     * Method that initializes the history.
     */
    private synchronized void initHistory() {
        if (mHistoryTask != null &&
                !mHistoryTask.getStatus().equals(AsyncTask.Status.FINISHED)) {
            return;
        }

        // Load history in background
        mHistoryTask = new AsyncTask<Void, Void, Boolean>() {
            Exception mCause;

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    loadHistory();
                    return Boolean.TRUE;
                }
                catch (Exception e) {
                    this.mCause = e;
                    return Boolean.FALSE;
                }
            }

            @Override
            protected void onPreExecute() {
                mDrawerHistory.removeAllViews();
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (result.booleanValue()) {
                    for (int i = 0; i < mHistory.size(); i++) {
                        final History history = mHistory.get(i);
                        addHistoryToDrawer(i, history.getItem());
                    }
                } else {
                    if (this.mCause != null) {
                        ExceptionUtil.translateException(
                                NavigationActivity.this, this.mCause);
                    }
                }
                mHistoryTask = null;
                mHistory.clear();
            }

            @Override
            protected void onCancelled() {
                mHistoryTask = null;
            }
        };
        mHistoryTask.execute();
    }

