    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

