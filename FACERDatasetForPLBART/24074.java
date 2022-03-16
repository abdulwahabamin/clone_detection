    public static void queueAndPlayImmediately(Context context, long[] songs) {
        if (sService == null) {
            return;
        }
        sService.enqueue(songs, MediaPlayback.NOW);
    }

