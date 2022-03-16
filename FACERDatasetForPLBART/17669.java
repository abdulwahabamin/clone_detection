    public ArtistsPresenter(DataManager dataManager,
                            MediaBrowserManager mediaBrowserManager,
                            PublishSubject<MediaBrowserCompat.MediaItem> artistClickSubject,
                            PublishSubject<Integer> artistsScrollToTopSubject) {
        super(dataManager);
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
        mArtistClickSubject = artistClickSubject;
        mArtistsScrollToTopSubject = artistsScrollToTopSubject;
    }

