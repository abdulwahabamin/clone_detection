    /**
     * Sets the seekbar's duration. Also updates the 
     * elapsed/remaining duration text.
     */
    private void setSeekbarDuration(int duration) {
    	mSeekbar.setMax(duration);
        mSeekbar.setProgress(mApp.getService().getCurrentMediaPlayer().getCurrentPosition()/1000);
    	mHandler.postDelayed(seekbarUpdateRunnable, 100);
    }

