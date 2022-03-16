    @Provides
    @Singleton
    @Named(PROVIDER_PLAYLISTS_SCROLL_TO_TOP)
    PublishSubject<Integer> getPlaylistsScrollToTopProvider() {
        return PublishSubject.create();
    }

