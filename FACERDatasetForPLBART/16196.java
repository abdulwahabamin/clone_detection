    @Override
    public void onCreate() {
        player = new MusicPlayer(getApplicationContext());
        handler = new EasyHandler();
        handler.createHandler(PLAYER_HANDLER_THREAD_NAME);
        player.registerOnCompletionListener(this);
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

