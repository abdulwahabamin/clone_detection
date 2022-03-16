    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((MediaPlaybackService.LocalBinder)binder).getService();

        notifyFragmentConnected(R.id.player_header, service);
        notifyFragmentConnected(R.id.playqueue, service);
        notifyFragmentConnected(R.id.player_footer, service);
        notifyFragmentConnected(R.id.nowplaying, service);

        if (songToPlay > -1) {
            MusicUtils.playSong(this, songToPlay);
            songToPlay = -1;
        }

        invalidateOptionsMenu();
    }

