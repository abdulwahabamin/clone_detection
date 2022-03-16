    @Override
    public void onResume() {
        super.onResume();
        fragmentPaused = false;
        if (mProgress != null)
            mProgress.postDelayed(mUpdateProgress, 10);

        if (mCircularProgress != null)
            mCircularProgress.postDelayed(mUpdateCircularProgress, 10);
    }

