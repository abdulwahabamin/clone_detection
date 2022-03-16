    public PlaylistsPresenter(DataManager dataManager,
                              MediaBrowserManager mediaBrowserManager,
                              PublishSubject<Integer> playlistsScrollToTopSubject,
                              PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>>
                                      playlistClickSubject,
                              PublishSubject<String> playlistsChangedSubject) {
        super(dataManager);
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
        mPlaylistsScrollToTopSubject = playlistsScrollToTopSubject;
        mPlaylistClickSubject = playlistClickSubject;
        mPlaylistsChangedSubject = playlistsChangedSubject;
    }

