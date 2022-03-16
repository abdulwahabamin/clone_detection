	public static Bitmap getThumbImageFromDisk( Context context, File nFile, int thumbSize ){
		if(!nFile.exists())
			return null;
		final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try{
        	BitmapFactory.decodeFile( nFile.getAbsolutePath() , options);
        }
        catch(Exception e){
        }
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > thumbSize || width > thumbSize) {
             if (width > height) {
                 inSampleSize = Math.round((float)height / (float)thumbSize);
             } else {
                 inSampleSize = Math.round((float)width / (float)thumbSize);
             }
             final float totalPixels = width * height;
             final float totalReqPixelsCap = thumbSize * thumbSize * 2;
             while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                 inSampleSize++;
             }
        }
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = null;
		try{
			bitmap = BitmapFactory.decodeFile( nFile.getAbsolutePath() , options );
		}
		catch (Exception e){
		}
        return  bitmap;
	}

