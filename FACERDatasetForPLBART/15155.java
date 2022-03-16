    public static void startTracksBrowser(String Type, long id, Cursor mCursor, Context context ) {
    	Bundle bundle = new Bundle();
        if( Type == TYPE_ARTIST ){
        	String artistName = mCursor.getString(mCursor.getColumnIndexOrThrow(ArtistColumns.ARTIST));
            String artistNulAlbums = mCursor.getString( mCursor.getColumnIndexOrThrow(ArtistColumns.NUMBER_OF_ALBUMS));        
            bundle.putString(MIME_TYPE, Audio.Artists.CONTENT_TYPE);
            bundle.putString(ARTIST_KEY, artistName);
            bundle.putString(NUMALBUMS, artistNulAlbums);
            ApolloUtils.setArtistId(artistName, id, ARTIST_ID, context);    	
        }
        else if( Type == TYPE_ALBUM ){            
            String artistName = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ARTIST));
            String albumName = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ALBUM));
            String albumId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
            bundle.putString(MIME_TYPE, Audio.Albums.CONTENT_TYPE);
            bundle.putString(ARTIST_KEY, artistName);
            bundle.putString(ALBUM_KEY, albumName);
            bundle.putString(ALBUM_ID_KEY, albumId);
            bundle.putBoolean(UP_STARTS_ALBUM_ACTIVITY, true);
        }
        else if( Type == TYPE_GENRE ){
            String genreKey = mCursor.getString(mCursor.getColumnIndexOrThrow(Audio.Genres.NAME));
            bundle.putString(MIME_TYPE, Audio.Genres.CONTENT_TYPE);
            bundle.putString(GENRE_KEY, genreKey);
        }
        else if( Type == TYPE_PLAYLIST ){
            String playlistName = mCursor.getString(mCursor.getColumnIndexOrThrow(PlaylistsColumns.NAME));
            bundle.putString(MIME_TYPE, Audio.Playlists.CONTENT_TYPE);
            bundle.putString(PLAYLIST_NAME, playlistName);
            bundle.putLong(BaseColumns._ID, id);
        }
        
        bundle.putLong(BaseColumns._ID, id);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClass(context, TracksBrowser.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

