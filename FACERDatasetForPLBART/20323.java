    /**
     * Input stream containing image data.
     * <p>
     * If this returns {@code null}, image data will be available via {@link #getBitmap()}.
     */
    public InputStream getInputStream() {
      return stream;
    }

