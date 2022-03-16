    @Provides
    @PerActivity
    AlbumsPresenter getAlbumsPresenter(DataManager dataManager,
                                       @Named(BusModule.PROVIDER_ALBUM_CLICK)
                                       PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>>
                                               albumClickSubject,
                                       @Named(BusModule.PROVIDER_ALBUMS_SCROLL_TO_TOP)
                                               PublishSubject<Integer> albumsScrollToTopSubject) {
        return new AlbumsPresenter(
                dataManager,
                new MediaBrowserManager(
                        MediaIdHelper.ALBUMS_ROOT_HINT, AlbumsPresenter.class.getSimpleName()),
                albumClickSubject,
                albumsScrollToTopSubject);
    }

