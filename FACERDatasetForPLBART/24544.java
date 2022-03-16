    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;

        notifyFragmentDisconnected(R.id.play_queue_fragment);
        notifyFragmentDisconnected(R.id.now_playing_fragment);

        finish();
    }

