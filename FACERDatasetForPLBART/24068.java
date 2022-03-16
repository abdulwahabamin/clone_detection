    public static void playSong(Context context, long id) {
        switch (PreferenceManager.getDefaultSharedPreferences(context).getString(
                SettingsActivity.CLICK_ON_SONG, SettingsActivity.PLAY_NEXT)) {
            case SettingsActivity.PLAY_NOW:
                MusicUtils.queueAndPlayImmediately(context, new long[] { id });
                break;
            case SettingsActivity.QUEUE:
                MusicUtils.queue(context, new long[] { id });
                break;
            default:
                MusicUtils.queueNextAndPlayIfNotAlreadyPlaying(context, new long[] { id });
                break;
        }
    }

