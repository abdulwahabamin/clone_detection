    @Provides
    @Singleton
    @Named(PROVIDER_SELECTED_SONG)
    PublishSubject<MediaBrowserCompat.MediaItem> getSelectedSongProvider() {
        return PublishSubject.create();
    }

