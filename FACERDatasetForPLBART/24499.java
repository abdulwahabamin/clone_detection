    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((MediaPlaybackService.LocalBinder) binder).getService();

        notifyFragmentConnected(R.id.browser_fragment, service);
    }

