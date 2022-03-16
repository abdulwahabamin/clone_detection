    private MusicProvider(MusicProviderSource localSource, MusicProviderSource remoteSource) {
        this.localSource = localSource;
        this.remoteSource = remoteSource;
        musicList = new CopyOnWriteArrayList<>();
        mediaList = new CopyOnWriteArrayList<>();
    }

