    public PlaybackManager(PlaybackServiceCallback serviceCallback,
                           MusicProvider musicProvider,
                           QueueManager queueManager,
                           Playback playback,
                           PlaylistsManager playlistsManager) {
        mMusicProvider = musicProvider;
        mServiceCallback = serviceCallback;
        mQueueManager = queueManager;
        mMediaSessionCallback = new MediaSessionCallback();
        mPlayback = playback;
        mPlayback.setCallback(this);
        mPlaylistsManager = playlistsManager;

        mShuffleMode = 0;
        mRepeatMode = PlaybackStateCompat.REPEAT_MODE_NONE;
    }

