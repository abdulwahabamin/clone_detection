    @Override
    public void onSeekUpdate(int currentSeek) {
        if(!userSeeking) {
            seekBar.setProgress(currentSeek);
        }
    }

