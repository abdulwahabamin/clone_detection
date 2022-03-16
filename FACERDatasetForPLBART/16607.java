    @Override
    public void onCreate() {
        super.onCreate();
        FireLog.d(TAG, "(++) onCreate");

        // Start a new MediaSession
        session = new MediaSessionCompat(this, MusicPlayerService.class.getSimpleName());
        setSessionToken(session.getSessionToken());

        musicProvider = MusicProvider.getInstance();

        QueueManager queueManager = new QueueManager(musicProvider, metadataUpdateListener);
        MediaPlayback playback = new MediaPlayback(this);
        playbackManager = new PlaybackManager(this, queueManager, playback);

        session.setCallback(playbackManager.getMediaSessionCallback());
        session.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
                MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);

        playbackManager.updatePlaybackState(null);

        try {
            mediaNotificationManager = new MediaNotificationManager(this);
        } catch (RemoteException e) {
            throw new IllegalStateException("Could not create a MediaNotificationManager", e);
        }
    }

