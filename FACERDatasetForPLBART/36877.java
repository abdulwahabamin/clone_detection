    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Preferences.isNightMode()) {
            setTheme(getDarkTheme());
        }

        super.onCreate(savedInstanceState);
        handler = new Handler(Looper.getMainLooper());
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

