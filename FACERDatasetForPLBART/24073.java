    public static void queueNext(Context context, long[] songs) {
        if (sService == null) {
            return;
        }
        sService.enqueue(songs, MediaPlayback.NEXT);
        Toast.makeText(context, R.string.will_play_next, Toast.LENGTH_SHORT).show();
    }

