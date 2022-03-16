    @Provides
    @PerActivity
    AllSongsPresenter getAllSongsPresenter(DataManager dataManager,
                                           @Named(BusModule.PROVIDER_SELECTED_SONG)
                                                   PublishSubject<MediaBrowserCompat.MediaItem>
                                                   selectedSongSubject,
                                           @Named(BusModule.PROVIDER_ALL_SONGS_SCROLL_TO_TOP)
                                                   PublishSubject<Integer> allSongsScrollToTopSubject) {
        return new AllSongsPresenter(dataManager,
                new MediaBrowserManager(
                        MediaIdHelper.ALL_SONGS_ROOT_HINT,
                        AllSongsPresenter.class.getSimpleName()),
                selectedSongSubject,
                allSongsScrollToTopSubject);
    }

