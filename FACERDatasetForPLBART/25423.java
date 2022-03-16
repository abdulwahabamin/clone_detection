    private void playQueue() {
        release();
        File f = new File(filesQueue.get(currentlyPlaying).fileName);
        Uri musicUri = Uri.fromFile(f);
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(getApplicationContext(), musicUri);
        } catch (java.io.IOException e) {
            // TODO
        }
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.prepareAsync();
    }

