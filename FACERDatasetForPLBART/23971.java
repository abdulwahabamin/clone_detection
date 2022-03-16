    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate");

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        mPersistentState = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

        mSettings = PreferenceManager.getDefaultSharedPreferences(this);

        mCardId = fetchCardId();

        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_MEDIA_EJECT);
        iFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        iFilter.addDataScheme("file");
        registerReceiver(mUnmountReceiver, iFilter);

        // Needs to be done in this thread, since otherwise ApplicationContext.getPowerManager() crashes.
        mPlayers[0] = new MyMediaPlayer(this, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                handlePlayerCallback(0, msg);
            }
        });
        mPlayers[1] = new MyMediaPlayer(this, new Handler() {
            @Override
            public void handleMessage(Message msg) {
                handlePlayerCallback(1, msg);
            }
        });
        mCurrentPlayer = 0;
        mNextPlayer = 1;

        mCurrentVolume[0] = 1.0f;
        mCurrentVolume[1] = 1.0f;

        reloadQueue();

        IntentFilter actionFilter = new IntentFilter();
        actionFilter.addAction(TOGGLEPAUSE_ACTION);
        actionFilter.addAction(PLAY_ACTION);
        actionFilter.addAction(PAUSE_ACTION);
        actionFilter.addAction(STOP_ACTION);
        actionFilter.addAction(NEXT_ACTION);
        actionFilter.addAction(PREVIOUS_ACTION);
        enrichActionFilter(actionFilter);
        actionFilter.addAction(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        registerReceiver(mIntentReceiver, actionFilter);

        createMediaSession();

        additionalCreate();

        // If the service was idle, but got killed before it stopped itself, the
        // system will relaunch it. Make sure it gets stopped again in that case.
        Message msg = mDelayedStopHandler.obtainMessage();
        mDelayedStopHandler.sendMessageDelayed(msg, IDLE_DELAY_MILLIS);
    }

