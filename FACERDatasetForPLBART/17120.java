    @Provides
    @PerActivity
    MusicPlayerPresenter getMusicPlayerPresenter(DataManager dataManager,
                                                 @Named(BusModule.PROVIDER_QUEUE_INDEX_UPDATED)
                                                         PublishSubject<Integer>
                                                         queueIndexUpdatedPublishSubject,
                                                 @Named(BusModule.PROVIDER_MUSIC_PLAYER_PANEL)
                                                         PublishSubject<Integer>
                                                         musicPlayerPanelPublishSubject) {
        return new MusicPlayerPresenter(
                dataManager,
                new MediaBrowserManager(null, MusicPlayerPresenter.class.getSimpleName()),
                queueIndexUpdatedPublishSubject,
                musicPlayerPanelPublishSubject);
    }

