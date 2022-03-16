	/**
	 * Prepares the MediaPlayer objects for first use 
	 * and starts the service. The workflow of the entire 
	 * service starts here.
	 * 
	 * @param intent Calling intent.
	 * @param flags Service flags.
	 * @param startId Service start ID.
	 */
	@SuppressLint("NewApi")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        
		//Context.
		mContext = getApplicationContext();
		mService = this;
		mHandler = new Handler();
		
        mApp = (Common) getApplicationContext();
        mApp.setService((AudioPlaybackService) this);
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
  
        //Initialize Google Analytics.
        initGoogleAnalytics();
        
        //Initialize the MediaPlayer objects.
        initMediaPlayers();
		
		//Time to play nice with other music players (and audio apps) and request audio focus.
		mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		mAudioManagerHelper = new AudioManagerHelper();
		
		// Request audio focus for playback
		mAudioManagerHelper.setHasAudioFocus(requestAudioFocus());

        //Grab the crossfade duration for this session.
        mCrossfadeDuration = mApp.getCrossfadeDuration();

		//Initialize audio effects (equalizer, virtualizer, bass boost) for this session.
		initAudioFX();
		
	    mMediaButtonReceiverComponent = new ComponentName(this.getPackageName(), HeadsetButtonsReceiver.class.getName());
	    mAudioManager.registerMediaButtonEventReceiver(mMediaButtonReceiverComponent);
	    
	    //if (mApp.getSharedPreferences().getBoolean(Common.SHOW_LOCKSCREEN_CONTROLS, true)==true) {
	    //	initRemoteControlClient();
	    //}
	    
		mApp.getPlaybackKickstarter().setBuildCursorListener(buildCursorListener);
		
		//The service has been successfully started.
		setPrepareServiceListener(mApp.getPlaybackKickstarter());
	    getPrepareServiceListener().onServiceRunning(this);
	    
		return START_STICKY;
	}

