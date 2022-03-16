    public LocalPlayback(Context context, MusicProvider musicProvider) {
        this.mContext = context.getApplicationContext();
        this.mMusicProvider = musicProvider;

        this.mAudioManager =
                (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        initMediaPlayer();
    }

