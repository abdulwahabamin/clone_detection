    public static File getImageFromWeb( Context context, ImageInfo imageInfo ) {
    	String imageUrl = null;
        try {
	        if( imageInfo.type.equals(TYPE_ALBUM) ){  
	        	Album image = Album.getInfo(imageInfo.data[1], imageInfo.data[2], LASTFM_API_KEY);
	            if (image != null) {
	            	imageUrl = image.getLargestImage();
	            }
	        }
	        else if( imageInfo.type.equals(TYPE_ARTIST) ){
	        	Artist image = Artist.getInfo(imageInfo.data[0], LASTFM_API_KEY);
	            if (image != null) {
	            	imageUrl = image.getLargestImage();
	            }
	        }
        } catch ( Exception e ) {
        	e.printStackTrace();
        	return null;
        }
        if ( imageUrl == null || imageUrl.isEmpty() ) {
            return null;
        }
        File newFile = getFile( context, imageInfo );
        ApolloUtils.downloadFile( imageUrl, newFile );
		if (newFile.exists()) {
            return newFile;
        }
        return null;
    }    

