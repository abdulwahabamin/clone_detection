    public void next() {
        player.reset();
        onSeekUpdated(0);
        playQueue.next();
        editor.putInt(LAST_SEEK, 0).apply();
        editor.putInt(LAST_SONG_INDEX, playQueue.getIndex()).apply();
    }

