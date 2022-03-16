    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        String shuf = getIntent().getStringExtra("autoshuffle");
        if ("true".equals(shuf)) {
            mAutoShuffle = true;
        }
        MusicUtils.bindToService(this, new ServiceConnection() {
            public void onServiceConnected(ComponentName classname, IBinder obj) {
                updateMenu();
            }

            public void onServiceDisconnected(ComponentName classname) {
                updateMenu();
            }
        
        });
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        init();
    }

