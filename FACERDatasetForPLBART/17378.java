    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate:called");

        DaggerUiComponent.builder()
                .uiModule(new UiModule(this))
                .applicationComponent(((MyApplication)getApplicationContext())
                        .getApplicationComponent())
                .build()
                .inject(this);

        MusicProviderSource musicProviderSource = new LocalMusicSource(mDataManager);

        mMusicProvider = new MusicProviderImpl(musicProviderSource);

        mPlaylistsManager =
                new PlaylistsManager(new LocalPlaylistsSource(mDataManager), mMusicProvider, this);
        mPlaylistsManager.retrievePlaylists();

        mMediaSession = new MediaSessionCompat(this, TAG);

        mMediaSession.setFlags(
                MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
                        MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS
        );

        QueueManager queueManager = new QueueManager(mMusicProvider,
                new QueueManager.MetadataUpdateListener() {
                    @Override
                    public void onMetadataChanged(MediaMetadataCompat metadata) {
                        Log.d(TAG, "onMetadataChanged:called");
                        Log.i(TAG, "onMetadataChanged:metadata="+metadata);
                        mMediaSession.setMetadata(metadata);
                    }

                    @Override
                    public void onMetadataRetrieveError() {
                        //todo implement
                    }

                    @Override
                    public void onQueueUpdated(String title,
                                               List<MediaSessionCompat.QueueItem> newQueue) {
                        Log.d(TAG, "onQueueUpdated:called");
                        Log.i(TAG, "onQueueUpdated:title="+title);
                        Log.i(TAG, "onQueueUpdated:queue="+newQueue);
                        mMediaSession.setQueue(newQueue);
                        mMediaSession.setQueueTitle(title);
                    }

                    @Override
                    public void onCurrentQueueIndexUpdated(int currentIndex) {
                        Log.d(TAG, "onCurrentQueueIndexUpdated:called");
                        mQueueIndexUpdatedSubject.onNext(currentIndex);
                    }
                }
                ,mPlaylistsManager);

        LocalPlayback playback = new LocalPlayback(this, mMusicProvider);

        mPlaybackManager = new PlaybackManager(this, mMusicProvider, queueManager, playback,
                mPlaylistsManager);

        mMediaSession.setCallback(new MediaSessionCallback());

        // Set the session's token so that client activities can communicate with it.
        setSessionToken(mMediaSession.getSessionToken());

        // Set an initial PlaybackState with ACTION_PLAY, so media buttons can start the player
        PlaybackStateCompat.Builder mStateBuilder = new PlaybackStateCompat.Builder()
                .setActions(
                        PlaybackStateCompat.ACTION_PLAY |
                                PlaybackStateCompat.ACTION_PLAY_PAUSE);
        mMediaSession.setPlaybackState(mStateBuilder.build());

        try {
            mMediaNotificationManager = new MediaNotificationManager(this);
        } catch (RemoteException e) {
            throw new IllegalStateException("Could not create a MediaNotificationManager", e);
        }
    }

