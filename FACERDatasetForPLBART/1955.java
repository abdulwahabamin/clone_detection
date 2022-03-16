    public static Bitmap scaleBitmapToHD(Bitmap bitmap) {
        int destX = 1280;
        int destY = 720;
		/*
		 * int srcX = bitmap.getWidth(); int scrY = bitmap.getHeight();
		 *
		 * double scaleX, scaleY; scaleX = destX / srcX; scaleY = destY / scrY;
		 * double scale = Math.min( scaleX, scaleY );
		 */
        return Bitmap.createScaledBitmap(bitmap, destX, destY, false);
    }

