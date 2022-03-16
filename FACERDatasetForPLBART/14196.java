	public static Bitmap getNormalImageFromDisk( Context context, ImageInfo imageInfo ){
		Bitmap bitmap = null;
		File nFile = getFile( context, imageInfo );
		if(nFile.exists()){
			bitmap = BitmapFactory.decodeFile( nFile.getAbsolutePath() );
		}		
		return bitmap;
	}

