    @Provides
    @Singleton
    @Named(PROVIDER_PLAYLISTS_CHANGED)
    PublishSubject<String> getPlaylistsChangedProvider() {
        return PublishSubject.create();
    }

