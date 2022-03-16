    /**
     * Response stream and info.
     *
     * @param stream Image data stream.
     * @param loadedFromCache {@code true} if the source of the stream is from a local disk cache.
     * @deprecated Use {@link Response#Response(java.io.InputStream, boolean, long)} instead.
     */
    @Deprecated @SuppressWarnings("UnusedDeclaration")
    public Response(InputStream stream, boolean loadedFromCache) {
      this(stream, loadedFromCache, -1);
    }

