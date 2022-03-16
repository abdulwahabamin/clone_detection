    /**
     * Calculates the sample size for the resampling process.
	 *
     * @return The sample size.
     */
    public int calculateSampleSize(int width, int height, int targetWidth, int targetHeight) {
        float bitmapWidth = width;
        float bitmapHeight = height;

        int bitmapResolution = (int) (bitmapWidth * bitmapHeight);
        int targetResolution = targetWidth * targetHeight;

        int sampleSize = 1;

        if (targetResolution == 0) {
            return sampleSize;
        }

        for (int i = 1; (bitmapResolution / i) > targetResolution; i *= 2) {
            sampleSize = i;
        }

        return sampleSize;
    }

