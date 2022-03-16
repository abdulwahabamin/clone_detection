    @Provides
    @PerActivity
    PlaylistPresenter getPlaylistPresenter(DataManager dataManager,
                                          @Named(BusModule.PROVIDER_SELECTED_SONG)
                                             PublishSubject<MediaBrowserCompat.MediaItem>
                                             selectedSongSubject,
                                           @Named(BusModule.PROVIDER_PLAYLISTS_CHANGED)
                                                   PublishSubject<String> playlistsChangedSubject) {
        return new PlaylistPresenter(dataManager,
                new MediaBrowserManager(MediaIdHelper.PLAYLISTS_ROOT_HINT,
                        PlaylistPresenter.class.getSimpleName()),
                selectedSongSubject, playlistsChangedSubject);
    }

