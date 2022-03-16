    /**
     * Helper method for getFragmentCursor(). Returns the correct 
     * cursor retrieval method for the specified fragment.
     */
    private Cursor getFragmentCursorHelper(String querySelection, int fragmentId) {
    	switch (fragmentId) {
    	case Common.ARTISTS_FRAGMENT:
    		return getAllUniqueArtists(querySelection);
    	case Common.ALBUM_ARTISTS_FRAGMENT:
    		return getAllUniqueAlbumArtists(querySelection);
    	case Common.ALBUMS_FRAGMENT:
    		return getAllUniqueAlbums(querySelection);
    	case Common.SONGS_FRAGMENT:
            querySelection += " ORDER BY " + SONG_TITLE + " ASC";
    		return getAllSongsSearchable(querySelection);
    	case Common.PLAYLISTS_FRAGMENT:
            //TODO case stub.
    	case Common.GENRES_FRAGMENT:
    		return getAllUniqueGenres(querySelection);
    	case Common.FOLDERS_FRAGMENT:
    		//TODO case stub.
    	case Common.ARTISTS_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsByArtist(querySelection);
    	case Common.ARTISTS_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsInAlbumByArtist(querySelection);
    	case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsByAlbumArtist(querySelection);
    	case Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsInAlbumByAlbumArtist(querySelection);
    	case Common.ALBUMS_FLIPPED_FRAGMENT:
    		return getAllSongsInAlbumByArtist(querySelection);
    	case Common.GENRES_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsInGenre(querySelection);
    	case Common.GENRES_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsInAlbumInGenre(querySelection);
    	default:
    		return null;
    	}
    	
    }

