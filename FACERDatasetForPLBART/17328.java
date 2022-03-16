    public QueueManager(MusicProvider musicProvider,
                        MetadataUpdateListener metadataUpdateListener,
                        PlaylistsManager playlistsManager) {
        mMusicProvider = musicProvider;
        mMetadataUpdateListener = metadataUpdateListener;
        mPlaylistsManager = playlistsManager;

        mPlayingQueue = Collections.synchronizedList(new ArrayList<MediaSessionCompat.QueueItem>());
        mCurrentIndex = 0;
    }

