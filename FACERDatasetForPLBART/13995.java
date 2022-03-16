    /**
     * @return number of albums from Bundle
     */
    public String getNumAlbums() {
        if (bundle.getString(NUMALBUMS) != null)
            return bundle.getString(NUMALBUMS);
        String[] projection = {
                BaseColumns._ID, ArtistColumns.ARTIST, ArtistColumns.NUMBER_OF_ALBUMS
        };
        Uri uri = Audio.Artists.EXTERNAL_CONTENT_URI;        
        Long id = ApolloUtils.getArtistId(getArtist(), ARTIST_ID, this);
        Cursor cursor = null;
        try{
        	cursor = this.getContentResolver().query(uri, projection, BaseColumns._ID+ "=" + DatabaseUtils.sqlEscapeString(String.valueOf(id)), null, null);
        }
        catch(Exception e){
        	e.printStackTrace();        	
        }
        if(cursor == null)
        	return String.valueOf(0);
        int mArtistNumAlbumsIndex = cursor.getColumnIndexOrThrow(ArtistColumns.NUMBER_OF_ALBUMS);
        if(cursor.getCount()>0){
	    	cursor.moveToFirst();
	        String numAlbums = cursor.getString(mArtistNumAlbumsIndex);	  
	        if(numAlbums != null){
	        	return numAlbums;
	        }
        }        
        return String.valueOf(0);
    }

