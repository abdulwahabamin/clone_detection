    @Provides
    @PerActivity
    MiniPlayerPresenter getMiniPlayerPresenter(DataManager dataManager,
                                               @Named(BusModule.PROVIDER_MUSIC_PLAYER_PANEL)
                                                       PublishSubject<Integer>
                                                       musicPlayerPanelPublishSubject) {
        return  new MiniPlayerPresenter(
                dataManager,
                new MediaBrowserManager(null, MiniPlayerPresenter.class.getSimpleName()),
                musicPlayerPanelPublishSubject);
    }

