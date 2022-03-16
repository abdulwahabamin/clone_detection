    @Override
    protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        mResult = null;

        getContext().getContentResolver().unregisterContentObserver(mObserver);
    }

