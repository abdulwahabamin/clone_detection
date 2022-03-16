    public MiniPlayerPresenter(DataManager dataManager,
                               MediaBrowserManager browserManager,
                               PublishSubject<Integer> musicPlayerPanelPublishSubject) {
        super(dataManager);
        mMediaBrowserManager = browserManager;
        mMediaBrowserManager.setCallback(this);
        mMediaBrowserManager.setControllerCallback(mMediaControllerCallback);
        mMusicPlayerPanelPublishSubject = musicPlayerPanelPublishSubject;
    }

