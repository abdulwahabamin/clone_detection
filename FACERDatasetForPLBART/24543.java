    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((MediaPlaybackService.LocalBinder) binder).getService();

        notifyFragmentConnected(R.id.now_playing_fragment, service);
        notifyFragmentConnected(R.id.play_queue_fragment, service);
    }

