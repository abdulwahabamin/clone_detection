    /**
     * Calculates the sample size for the resampling process.
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return The sample size.
     */
	private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
	    final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;

	    if (height > reqHeight || width > reqWidth) {
	        if (width > height) {
	            inSampleSize = Math.round((float) height / (float) reqHeight);
	        } else {
	            inSampleSize = Math.round((float) width / (float) reqWidth);
	        }
	    }

	    return inSampleSize;
	}

