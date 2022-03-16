    @Provides
    @PerActivity
    AlbumPresenter getAlbumPresenter(DataManager dataManager,
                                           @Named(BusModule.PROVIDER_SELECTED_SONG)
                                                   PublishSubject<MediaBrowserCompat.MediaItem>
                                                   selectedSongSubject) {
        return new AlbumPresenter(dataManager,
                new MediaBrowserManager(MediaIdHelper.ALBUMS_ROOT_HINT,
                        AlbumPresenter.class.getSimpleName()),
                selectedSongSubject);
    }

