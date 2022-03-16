    public void newQueue(PlayQueue queue) {
        player.reset();
        onSeekUpdated(0);
        Global.playQueue = queue;
        playQueue.saveQueueToFile(PLAY_QUEUE_FILE_PATH);
        editor.putInt(LAST_SEEK, 0).apply();
        editor.putInt(LAST_SONG_INDEX, playQueue.getIndex()).apply();
    }

