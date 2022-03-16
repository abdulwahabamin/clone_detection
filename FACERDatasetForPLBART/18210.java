    public AsyncCreateNewPlaylistTask(Context context, 
    								  String playlistName, 
    								  String ARTIST, 
    								  String ALBUM, 
    								  String SONG, 
    								  String GENRE, 
    								  String ALBUM_ARTIST,
    								  String ADD_TYPE) {
    	
    	mContext = context;
    	mPlaylistName = playlistName;
    	sharedPreferences = context.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	musicLibraryDBHelper = new DBAccessHelper(mContext);
    	musicLibraryPlaylistsDBHelper = new DBAccessHelper(mContext);
    	
    	mArtist = ARTIST;
    	mAlbum = ALBUM;
    	mSong = SONG;
    	mGenre = GENRE;
    	mAlbumArtist = ALBUM_ARTIST;
    	mAddType = ADD_TYPE;
    }

