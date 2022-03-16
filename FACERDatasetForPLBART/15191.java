    public static long[] getSongList( String Type , Context context , long id ){
    	if ( Type == TYPE_ALBUM ){
    		return MusicUtils.getSongListForAlbum(context, id);    		
    	}
    	else if( Type == TYPE_ARTIST ){
    		return MusicUtils.getSongListForArtist(context, id);
    	}
    	else if( Type == TYPE_GENRE ){
    		return MusicUtils.getSongListForGenre(context, id);
    	}
    	else if ( Type == TYPE_PLAYLIST ){
    		return MusicUtils.getSongListForPlaylist(context, id);
    	}    	
    	return sEmptyList;
    }

