    @SuppressLint("NewApi")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            isPlayOnStart=intent.getExtras().getInt(SongPlayback.isPlayFromMain, SongPlayback.isPlayFromMainFalse);
            getAction=intent.getExtras().getInt(SongPlayback.RestartServiceAction, MainActivity.forNothingKey);
        }
        catch (Exception e){}

        mContext = getApplicationContext();
        mService = this;
        Boolean get=true;
        try {
            get=intent.getBooleanExtra(SongPlayback.isStartFromMain,true);
        }
        catch (Exception e){}
        LoadSongList(get);

        PlayerConstants.mSongPlayback=this;

        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        mHandler = new Handler();

        initMediaPlayers();

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //mSongData= PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER);
        mAudioManagerHelper = new AudioManagerHelper();

        if (UtilFunctions.currentVersionSupportLockScreenControls())
        {
            RegisterRemoteClient();
        }
        if (!getCurrentMediaPlayer().isPlaying())
            getIntentAction();

        return START_STICKY;
    }

