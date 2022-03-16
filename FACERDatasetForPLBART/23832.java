    public void skipBack(View v) {
        Log.d(TAG, "skipBack() entry.");
        if (getCurrentPosition() < 5000)
            playPrev();
        else {
            seekTo(0);
            updateControls();
        }
    }

