    /**
     * Resamples the specified input image file to avoid OOM errors.
     *
     * @param inputFile Input file to be downsampled
     * @param reqWidth Width of the output file.
     * @param reqHeight Height of the output file.
     * @return The downsampled bitmap.
     */
    public Bitmap decodeSampledBitmapFromFile(File inputFile, int reqWidth, int reqHeight) {

    	InputStream is = null;
        try {

        	try {
				is = new FileInputStream(inputFile);
			} catch (Exception e) {
				//Return a null bitmap if there's an error reading the file.
				return null;
			}

            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, options);

            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;

            try {
				is = new FileInputStream(inputFile);
			} catch (FileNotFoundException e) {
				//Return a null bitmap if there's an error reading the file.
				return null;
			}

            return BitmapFactory.decodeStream(is, null, options);
        } finally {
            try {
            	if (is!=null) {
            		is.close();
            	}
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

