    @Override
    public void onResume() {
        super.onResume();

        MusicUtils.bindToService(this, new ServiceConnection() {
            public void onServiceConnected(ComponentName classname, IBinder obj) {
                try {
                    IntentFilter f = new IntentFilter();
                    f.addAction(MediaPlaybackService.ASYNC_OPEN_COMPLETE);
                    f.addAction(MediaPlaybackService.PLAYBACK_COMPLETE);
                    registerReceiver(mStatusListener, new IntentFilter(f));
                    MusicUtils.sService.openFileAsync(getIntent().getData().toString());
                } catch (RemoteException ex) {
                }
            }

            public void onServiceDisconnected(ComponentName classname) {
            }
        });
    }

