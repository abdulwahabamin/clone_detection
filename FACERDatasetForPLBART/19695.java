	/**
	 * Retrieves the image dimensions of the input file.
	 *
	 * @param url Url of the input file.
	 * @return A BitmapFactory.Options object with the output image dimensions.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
    public BitmapFactory.Options getBitmapDimensions(URL url) throws FileNotFoundException, IOException {
        BitmapFactory.Options outDimens = new BitmapFactory.Options();
        outDimens.inJustDecodeBounds = true; // the decoder will return null (no bitmap)

        InputStream is = url.openStream();
        // if Options requested only the size will be returned
        BitmapFactory.decodeStream(is, null, outDimens);
        is.close();

        return outDimens;
    }

