    /**
     * Response image and info.
     *
     * @param bitmap Image.
     * @param loadedFromCache {@code true} if the source of the image is from a local disk cache.
     * @param contentLength The content length of the response, typically derived by the
     * {@code Content-Length} HTTP header.
     */
    public Response(Bitmap bitmap, boolean loadedFromCache, long contentLength) {
      if (bitmap == null) {
        throw new IllegalArgumentException("Bitmap may not be null.");
      }
      this.stream = null;
      this.bitmap = bitmap;
      this.cached = loadedFromCache;
      this.contentLength = contentLength;
    }

