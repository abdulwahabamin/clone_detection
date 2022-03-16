    public static File getImageFromMediaStore( Context context, ImageInfo imageInfo ){
    	String mAlbum = imageInfo.data[0];
    	String[] projection = {
                BaseColumns._ID, Audio.Albums._ID, Audio.Albums.ALBUM_ART, Audio.Albums.ALBUM
        };
        Uri uri = Audio.Albums.EXTERNAL_CONTENT_URI;
        Cursor cursor = null;
        try{
        	cursor = context.getContentResolver().query(uri, projection, BaseColumns._ID+ "=" + DatabaseUtils.sqlEscapeString(mAlbum), null, null);
        }
        catch(Exception e){
        	e.printStackTrace();        	
        }
        int column_index = cursor.getColumnIndex(Audio.Albums.ALBUM_ART);
        if(cursor.getCount()>0){
	    	cursor.moveToFirst();
	        String albumArt = cursor.getString(column_index);	  
	        if(albumArt != null){
	        	try{
	        		File orgFile = new File(albumArt);
	        		File newFile = new File(context.getExternalCacheDir(), createShortTag(imageInfo)+IMAGE_EXTENSION);
	        		InputStream in = new FileInputStream(orgFile);
	        		OutputStream out = new FileOutputStream(newFile);
	        		byte[] buf = new byte[1024];
	        		int len;
	        		while ((len = in.read(buf)) > 0){
	        			out.write(buf, 0, len);
	        		}
	        		in.close();
	        		out.close();
	        		cursor.close();
		        	return newFile;
	        	}
	        	catch( Exception e){
	        	}
	        }
        }
        return null;
    }

