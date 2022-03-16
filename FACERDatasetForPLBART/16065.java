    @Override
    public void onSongPlaybackFailed() {
        showPlay();
        Toast.makeText(getContext(), "Unable to play " + playQueue.getCurrentPlaying().getTitle(),
                Toast.LENGTH_LONG).show();
    }

