    public QueueManager(@NonNull MusicProvider musicProvider,
                        @NonNull MetadataUpdateListener metadataUpdateListener) {
        this.musicProvider = musicProvider;
        this.metadataUpdateListener = metadataUpdateListener;

        playingQueue = Collections.synchronizedList(new ArrayList<MediaSessionCompat.QueueItem>());
        currentIndex = 0;
    }

