    @Override
    protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        for (RecentTask task : mTasks.values()) {
            IoUtils.closeQuietly(task);
        }

        IoUtils.closeQuietly(mResult);
        mResult = null;
    }

