    private static void startService(Context context, String command) {
        final Intent i = new Intent(context, MusicService.class);
        i.setAction(MusicService.SERVICECMD);
        i.putExtra(MusicService.CMDNAME, command);
        i.putExtra(MusicService.FROM_MEDIA_BUTTON, true);
        startWakefulService(context, i);
    }

