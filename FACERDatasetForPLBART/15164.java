    public static String createShortTag(ImageInfo imageInf){
    	String tag = null;
    	if( imageInf.type.equals( TYPE_ALBUM ) ){
    		//album id + album suffix 
    		tag = imageInf.data[0] + ALBUM_SUFFIX;
    	}
    	else if (imageInf.type.equals( TYPE_ARTIST )){
    		//artist name + album suffix
    		tag = imageInf.data[0] + ARTIST_SUFFIX;
    	}
    	else if (imageInf.type.equals( TYPE_GENRE )){
    		//genre name + genre suffix
    		tag = imageInf.data[0] + GENRE_SUFFIX;
    	}
    	else if (imageInf.type.equals( TYPE_PLAYLIST )){
    		//genre name + genre suffix
    		tag = imageInf.data[0] + PLAYLIST_SUFFIX;
    	}
    	ApolloUtils.escapeForFileSystem(tag);
    	return tag;
    }

