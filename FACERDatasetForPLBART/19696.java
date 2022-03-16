    /**
     * Resamples a resource image to avoid OOM errors.
     *
     * @param resID Resource ID of the image to be downsampled.
     * @param reqWidth Width of output image.
     * @param reqHeight Height of output image.
     *
     * @return A bitmap of the resampled image.
     */
    public Bitmap decodeSampledBitmapFromResource(int resID, int reqWidth, int reqHeight) {

	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
	    options.inJustDecodeBounds = false;
	    options.inPurgeable = true;

	    return BitmapFactory.decodeResource(mContext.getResources(), resID, options);
    }

