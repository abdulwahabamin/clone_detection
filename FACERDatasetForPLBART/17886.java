    public MusicPlayerPresenter(DataManager dataManager,
                                MediaBrowserManager browserManager,
                                PublishSubject<Integer> queueIndexUpdatedSubject,
                                PublishSubject<Integer> musicPlayerPanelPublishSubject) {
        super(dataManager);
        mMediaBrowserManager = browserManager;
        mMediaBrowserManager.setCallback(this);
        mMediaBrowserManager.setControllerCallback(mMediaControllerCallback);
        mQueueIndexUpdatedSubject = queueIndexUpdatedSubject;
        mMusicPlayerPanelPublishSubject = musicPlayerPanelPublishSubject;
    }

