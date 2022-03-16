    public void changeTrack(int songIndex) {
        player.reset();
        onSeekUpdated(0);
        playQueue.changeTrack(songIndex);
        editor.putInt(LAST_SEEK, 0).apply();
        editor.putInt(LAST_SONG_INDEX, playQueue.getIndex()).apply();
    }

