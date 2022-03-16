    @Provides
    @PerActivity
    PlaylistsPresenter getPlaylistsPresenter(DataManager dataManager,
                                         @Named(BusModule.PROVIDER_PLAYLIST_CLICK)
                                                 PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>>
                                                 playlistClickSubject,
                                         @Named(BusModule.PROVIDER_PLAYLISTS_SCROLL_TO_TOP)
                                                 PublishSubject<Integer> playlistsScrollToTopSubject,
                                         @Named(BusModule.PROVIDER_PLAYLISTS_CHANGED)
                                                 PublishSubject<String> playlistsChangedSubject) {
        return new PlaylistsPresenter(dataManager,
                new MediaBrowserManager(MediaIdHelper.PLAYLISTS_ROOT_HINT,
                        PlaylistsPresenter.class.getSimpleName()),
                playlistsScrollToTopSubject,
                playlistClickSubject,
                playlistsChangedSubject);
    }

