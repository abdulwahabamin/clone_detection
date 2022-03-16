    /**
     * constructor
     * @param musicProviderSource music provider is nothing without a musicsource
     */
    @SuppressWarnings("WeakerAccess")
    public MusicProvider(@NonNull MusicProviderSource musicProviderSource) {
        this.mSource = musicProviderSource;

        this.mMusicListById = new ConcurrentHashMap<>();
        this.mArtistListByKey = new ConcurrentHashMap<>();
        this.mAlbumListByKey = new ConcurrentHashMap<>();
        this.mMusicListByAlbumKey = new ConcurrentHashMap<>();
        this.mMusicListByArtistKey = new ConcurrentHashMap<>();
        this.mArtistArtByKey = new ConcurrentHashMap<>();
    }

