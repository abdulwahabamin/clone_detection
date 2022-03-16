  /**
   * Download the specified image {@code url} from the internet.
   *
   * @param uri Remote image URL.
   * @param localCacheOnly If {@code true} the URL should only be loaded if available in a local
   * disk cache.
   * @return {@link Response} containing either a {@link Bitmap} representation of the request or an
   * {@link InputStream} for the image data. {@code null} can be returned to indicate a problem
   * loading the bitmap.
   * @throws IOException if the requested URL cannot successfully be loaded.
   */
  Response load(Uri uri, boolean localCacheOnly) throws IOException;

