    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        mHandler=new Handler();
        int getAction=MainActivity.forNothingKey;
        int isPlay=SongPlayback.isPlayFromMainFalse;
        try {
            if (getIntent().hasExtra(SongPlayback.RestartServiceAction))
                getAction = getIntent().getExtras().getInt(SongPlayback.RestartServiceAction, MainActivity.forNothingKey);
            if (getIntent().hasExtra(SongPlayback.isPlayFromMain))
                isPlay = getIntent().getExtras().getInt(SongPlayback.isPlayFromMain, SongPlayback.isPlayFromMainFalse);
        }
        catch (Exception e){}

        setHandler();
        intent = new Intent(mContext, SongPlayback.class);
        intent.putExtra(SongPlayback.isPlayFromMain,isPlay);
        intent.putExtra(SongPlayback.RestartServiceAction,getAction);
        intent.putExtra(SongPlayback.isStartFromMain,false);
        intent1 = new Intent(mContext, MainActivity.class);
        activity=this;

        if (UtilFunctions.isServiceRunning(SongPlayback.class.getName(),this))
        {
            if (!PlayerConstants.mSongPlayback.getCurrentMediaPlayer().isPlaying() && !PlayerConstants.mSongPlayback.isPlay)
                mHandler.post(lastPosition);

            Cursor mCursor= MediaStoreAccessHelper.getAllSongs(mContext, null, null);
            if (PlayerConstants.SONGS_LIST == null
                    || PlayerConstants.SONGS_LIST.size() <= 0
                    || mCursor.getCount()!=PlayerConstants.SONGS_LIST.size()) {
                PlayerConstants.mSongPlayback.stopServiceManually();
                startService(intent);
            }
            else
                mHandler1.sendEmptyMessage(0);
        }
        else
        {
            mHandler.post(lastPosition);
            startService(intent);
        }

        SystemClock.sleep(TimeUnit.SECONDS.toMillis(2));
    }

