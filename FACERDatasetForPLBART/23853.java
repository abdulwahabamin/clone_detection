    private void startSeekTracking() {
        timerRunnable = new Runnable() {
            @Override
            public void run() {
                //Log.d(TAG, "timerRunnable.run() entry");
                updateSeekBar();
                updateCurrentTrackInfo();
                timerHandler.postDelayed(this, 1000);
            }
        };
        timerHandler.post(timerRunnable);
    }

