    public PlaylistsManager(@NonNull PlaylistsSource playlistsSource,
                            @NonNull MusicProvider musicProvider,
                            PlaylistsCallback playlistsCallback) {
        mPlaylistsSource = playlistsSource;
        mMusicProvider = musicProvider;
        mPlaylistsCallback = playlistsCallback;

        mPlaylistSongsByPlaylistKey = new ConcurrentHashMap<>();
        mAllPlaylistsByKey = new ConcurrentHashMap<>();
    }

