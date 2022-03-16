    public AlbumsPresenter(DataManager dataManager,
                           MediaBrowserManager mediaBrowserManager,
                           PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> albumClickSubject,
                           PublishSubject<Integer> albumsScrollToTopSubject) {
        super(dataManager);
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
        mAlbumClickSubject = albumClickSubject;
        mAlbumsScrollToTopSubject = albumsScrollToTopSubject;
    }

