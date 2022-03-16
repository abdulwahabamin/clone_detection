    @Provides
    @Singleton
    @Named(PROVIDER_ALBUM_CLICK)
    PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> getAlbumClickProvider() {
        return PublishSubject.create();
    }

