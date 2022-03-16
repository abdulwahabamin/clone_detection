    public PlaylistPresenter(DataManager dataManager,
                          MediaBrowserManager mediaBrowserManager,
                          PublishSubject<MediaBrowserCompat.MediaItem> selectedItemPublishSubject,
                             PublishSubject<String> playlistsChangedSubject) {
        super(dataManager);
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
        mSelectedItemPublishSubject = selectedItemPublishSubject;
        mPlaylistsChangedSubject = playlistsChangedSubject;
    }

