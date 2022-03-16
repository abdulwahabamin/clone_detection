    /**
     * Pass in an image url to get a drawable object
     * @return a drawable object
     * @throws IOException
     * @throws MalformedURLException
     */
    private static Drawable getDrawableFromUrl(final String url) throws IOException, MalformedURLException {
            return Drawable.createFromStream(((java.io.InputStream) new java.net.URL(url).getContent()), "name");

        /*
        if (profile != null) {
    Bitmap mIcon1 =
        BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
    profile.setImageBitmap(mIcon1);
}

         */
    }

