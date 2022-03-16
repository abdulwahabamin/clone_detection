    /**
     * Helper method for getFragmentCursor(). Returns the correct 
     * cursor retrieval method for the specified fragment in the 
     * specified library.
     */
    private Cursor getFragmentCursorInLibraryHelper(String querySelection, int fragmentId) {
    	switch (fragmentId) {
    	case Common.ARTISTS_FRAGMENT:
    		return getAllUniqueArtistsInLibrary(querySelection);
    	case Common.ALBUM_ARTISTS_FRAGMENT:
    		return getAllUniqueAlbumArtistsInLibrary(querySelection);
    	case Common.ALBUMS_FRAGMENT:
    		return getAllUniqueAlbumsInLibrary(querySelection);
    	case Common.SONGS_FRAGMENT:
    		return getAllSongsInLibrarySearchable(querySelection);
    	case Common.PLAYLISTS_FRAGMENT:
    		//TODO case stub.
    	case Common.GENRES_FRAGMENT:
    		return getAllUniqueGenresInLibrary(querySelection);
    	case Common.FOLDERS_FRAGMENT:
    		//TODO case stub.
    	case Common.ARTISTS_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsByArtistInLibrary(querySelection);
    	case Common.ARTISTS_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsInAlbumByArtistInLibrary(querySelection);
    	case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsByAlbumArtistInLibrary(querySelection);
    	case Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsInAlbumByAlbumArtistInLibrary(querySelection);
    	case Common.ALBUMS_FLIPPED_FRAGMENT:
    		return getAllSongsInAlbumByArtistInLibrary(querySelection);
    	case Common.GENRES_FLIPPED_FRAGMENT:
    		return getAllUniqueAlbumsInGenreInLibrary(querySelection);
    	case Common.GENRES_FLIPPED_SONGS_FRAGMENT:
    		return getAllSongsByInAlbumInGenreInLibrary(querySelection);
    	default:
    		return null;
    	}
    	
    }

