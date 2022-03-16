    @Provides
    @Singleton
    @Named(PROVIDER_MUSIC_PLAYER_PANEL)
    PublishSubject<Integer> getMusicPlayerPanelProvider() {
        return PublishSubject.create();
    }

