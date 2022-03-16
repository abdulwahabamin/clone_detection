    @Override
    public void onPause() {
        super.onPause();

        // cancel the timer
        mTimer.cancel();
        mTimer.purge();
    }

