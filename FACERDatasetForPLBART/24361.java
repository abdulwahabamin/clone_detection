    public void onServiceDisconnected(ComponentName name) {
        service = null;

        notifyFragmentDisconnected(R.id.player_header);
        notifyFragmentDisconnected(R.id.playqueue);
        notifyFragmentDisconnected(R.id.player_footer);
        notifyFragmentDisconnected(R.id.nowplaying);

        finish();
    }

