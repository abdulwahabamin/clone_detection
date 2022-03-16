    public void prev() {
        player.reset();
        onSeekUpdated(0);
        playQueue.prev();
        editor.putInt(LAST_SEEK, 0).apply();
        editor.putInt(LAST_SONG_INDEX, playQueue.getIndex()).apply();
    }

