    @Override
    public void onSongPlaybackFailed() {
        showPlay();
        Toast.makeText(this, "Unable to play " + playQueue.getCurrentPlaying().getTitle(),
                Toast.LENGTH_LONG).show();
    }

