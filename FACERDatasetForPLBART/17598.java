    public AllSongsPresenter(DataManager dataManager,
                             MediaBrowserManager mediaBrowserManager,
                             PublishSubject<MediaBrowserCompat.MediaItem> selectedItemPublishSubject,
                             PublishSubject<Integer> allSongsScrollToTopSubject) {
        super(dataManager);
        mMediaBrowserManager = mediaBrowserManager;
        mMediaBrowserManager.setCallback(this);
        mSelectedItemPublishSubject = selectedItemPublishSubject;
        mAllSongsScrollToTopSubject = allSongsScrollToTopSubject;
    }

