    @Provides
    @PerActivity
    ArtistPresenter getArtistPresenter(DataManager dataManager,
                                     @Named(BusModule.PROVIDER_SELECTED_SONG)
                                             PublishSubject<MediaBrowserCompat.MediaItem>
                                             selectedSongSubject) {
        return new ArtistPresenter(dataManager,
                new MediaBrowserManager(MediaIdHelper.ARTISTS_ROOT_HINT,
                        ArtistPresenter.class.getSimpleName()),
                selectedSongSubject);
    }

