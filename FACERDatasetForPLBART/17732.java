    public MainPresenter(DataManager dataManager,
                         PublishSubject<MediaBrowserCompat.MediaItem> selectedItemPublishSubject,
                         PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> albumClickSubject,
                         PublishSubject<MediaBrowserCompat.MediaItem> artistClickSubject,
                         PublishSubject<Integer> allSongsScrollToTopSubject,
                         PublishSubject<Integer> albumsScrollToTopSubject,
                         PublishSubject<Integer> artistsScrollToTopSubject,
                         PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> playlistClickSubject,
                         PublishSubject<Integer> playlistsScrollToTopSubject,
                         PublishSubject<Integer> musicPlayerPanelPublishSubject,
                         MediaBrowserManager mediaBrowserManager) {
        super(dataManager);
        mSelectedItemPublishSubject = selectedItemPublishSubject;
        mAlbumClickSubject = albumClickSubject;
        mArtistClickSubject = artistClickSubject;
        mAllSongsScrollToTopSubject = allSongsScrollToTopSubject;
        mAlbumsScrollToTopSubject = albumsScrollToTopSubject;
        mArtistsScrollToTopSubject = artistsScrollToTopSubject;
        mPlaylistClickSubject = playlistClickSubject;
        mPlaylistsScrollToTopSubject = playlistsScrollToTopSubject;
        mMusicPlayerPanelPublishSubject = musicPlayerPanelPublishSubject;
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
    }

