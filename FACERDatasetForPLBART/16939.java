    public static void startNowPlayingActivityIfNeeded(Activity activity, Intent intent) {
        if (intent != null && intent.getBooleanExtra(EXTRA_START_NOW_PLAYING, false)) {
            Intent nowPlayingIntent = new Intent(activity, NowPlayingActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .putExtra(EXTRA_CURRENT_MEDIA_DESCRIPTION,
                            intent.getParcelableExtra(EXTRA_CURRENT_MEDIA_DESCRIPTION));
            activity.startActivity(nowPlayingIntent);
        }
    }

