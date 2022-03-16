    @Provides
    @PerActivity
    MainPresenter getMainPresenter(DataManager dataManager,
                                   @Named(BusModule.PROVIDER_SELECTED_SONG)
                                   PublishSubject<MediaBrowserCompat.MediaItem> selectedSongSubject,
                                   @Named(BusModule.PROVIDER_ALBUM_CLICK)
                                   PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>> albumClickSubject,
                                   @Named(BusModule.PROVIDER_ARTIST_CLICK)
                                           PublishSubject<MediaBrowserCompat.MediaItem>
                                           artistClickSubject,
                                   @Named(BusModule.PROVIDER_PLAYLIST_CLICK)
                                           PublishSubject<Pair<MediaBrowserCompat.MediaItem, View>>
                                           playlistClickSubject,
                                   @Named(BusModule.PROVIDER_ALL_SONGS_SCROLL_TO_TOP)
                                           PublishSubject<Integer> allSongsScrollToTopSubject,
                                   @Named(BusModule.PROVIDER_ALBUMS_SCROLL_TO_TOP)
                                           PublishSubject<Integer> albumsScrollToTopSubject,
                                   @Named(BusModule.PROVIDER_PLAYLISTS_SCROLL_TO_TOP)
                                           PublishSubject<Integer> playlistsScrollToTopSubject,
                                   @Named(BusModule.PROVIDER_ARTISTS_SCROLL_TO_TOP)
                                           PublishSubject<Integer> artistsScrollToTopSubject,
                                   @Named(BusModule.PROVIDER_MUSIC_PLAYER_PANEL)
                                           PublishSubject<Integer> musicPlayerPanelPublishSubject
                                   ) {
        return new MainPresenter(
                dataManager,
                selectedSongSubject,
                albumClickSubject,
                artistClickSubject,
                allSongsScrollToTopSubject,
                albumsScrollToTopSubject,
                artistsScrollToTopSubject,
                playlistClickSubject,
                playlistsScrollToTopSubject,
                musicPlayerPanelPublishSubject,
                new MediaBrowserManager(MediaIdHelper.ALL_SONGS_ROOT_HINT,
                        MainPresenter.class.getSimpleName()));
    }

