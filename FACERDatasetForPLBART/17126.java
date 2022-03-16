    @Provides
    @PerActivity
    ArtistsPresenter getArtistsPresenter(DataManager dataManager,
                                         @Named(BusModule.PROVIDER_ARTIST_CLICK)
                                                 PublishSubject<MediaBrowserCompat.MediaItem>
                                                 artistClickSubject,
                                         @Named(BusModule.PROVIDER_ARTISTS_SCROLL_TO_TOP)
                                                 PublishSubject<Integer> artistsScrollToTopSubject) {
        return new ArtistsPresenter(dataManager,
                new MediaBrowserManager(MediaIdHelper.ARTISTS_ROOT_HINT,
                        ArtistsPresenter.class.getSimpleName()),
                artistClickSubject,
                artistsScrollToTopSubject);
    }

