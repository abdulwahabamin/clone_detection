    public void updateService(Bundle extras) {
        if (!MusicPlayer.isPlaybackServiceConnected()) return;
        final Intent intent = new Intent(context, MusicService.class);
        intent.setAction(MusicService.UPDATE_PREFERENCES);
        intent.putExtras(extras);
        context.startService(intent);
    }

