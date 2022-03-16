    @Provides
    @Singleton
    @Named(PROVIDER_PLAYLIST_CLICK)
    PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> getPlaylistClickProvider() {
        return PublishSubject.create();
    }

