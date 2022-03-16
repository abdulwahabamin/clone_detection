    @Provides
    @Singleton
    @Named(PROVIDER_ARTIST_CLICK)
    PublishSubject<MediaBrowserCompat.MediaItem> getArtistClickProvider() {
        return PublishSubject.create();
    }

