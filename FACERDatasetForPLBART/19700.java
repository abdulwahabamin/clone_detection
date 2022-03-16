    /**
     *
     * @param url
     * @param sampleSize
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Bitmap downsampleBitmap(URL url, int sampleSize) throws FileNotFoundException, IOException {
        Bitmap resizedBitmap;
        BitmapFactory.Options outBitmap = new BitmapFactory.Options();
        outBitmap.inJustDecodeBounds = false; // the decoder will return a bitmap
        outBitmap.inSampleSize = sampleSize;

        InputStream is = url.openStream();
        resizedBitmap = BitmapFactory.decodeStream(is, null, outBitmap);
        is.close();

        return resizedBitmap;
    }

