    private void fetchStats(String fileRoot) {
        if (!isFetching) {
            isFetching = true;
            mFetchStatsByTypeTask.execute(fileRoot);
        } else {
            Log.w(TAG, "Already fetching data...");
        }
    }

