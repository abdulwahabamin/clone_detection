    /**
     * Response stream and info.
     *
     * @param stream Image data stream.
     * @param loadedFromCache {@code true} if the source of the stream is from a local disk cache.
     * @param contentLength The content length of the response, typically derived by the
     * {@code Content-Length} HTTP header.
     */
    public Response(InputStream stream, boolean loadedFromCache, long contentLength) {
      if (stream == null) {
        throw new IllegalArgumentException("Stream may not be null.");
      }
      this.stream = stream;
      this.bitmap = null;
      this.cached = loadedFromCache;
      this.contentLength = contentLength;
    }

