    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            selectedPosition = savedInstanceState.getInt("selectedposition");
            selectedId = savedInstanceState.getLong("selectedtrack");
        }

        String uriString = getArguments() != null ? getArguments().getString(URI) : null;
        if (uriString != null) {
            uri = Uri.parse(uriString);
            isPlaylist = uriString.startsWith(MusicContract.Playlist.CONTENT_URI.toString());
            playlist = isPlaylist ? ContentUris.parseId(uri) : -1;
            isAlbum = uriString.startsWith(MusicContract.Album.CONTENT_URI.toString());
            isMedadataCategory = uriString.startsWith(MusicContract.Artist.CONTENT_URI.toString())
                    || uriString.startsWith(MusicContract.Album.CONTENT_URI.toString())
                    || uriString.startsWith(MusicContract.Genre.CONTENT_URI.toString());
        } else {
            uri = MusicContract.CONTENT_URI;
            isPlaylist = false;
            playlist = -1;
            isAlbum = false;
            isMedadataCategory = false;
        }
    }

