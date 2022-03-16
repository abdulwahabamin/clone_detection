    /**
     * Response image and info.
     *
     * @param bitmap Image.
     * @param loadedFromCache {@code true} if the source of the image is from a local disk cache.
     * @deprecated Use {@link Response#Response(android.graphics.Bitmap, boolean, long)} instead.
     */
    @Deprecated @SuppressWarnings("UnusedDeclaration")
    public Response(Bitmap bitmap, boolean loadedFromCache) {
      this(bitmap, loadedFromCache, -1);
    }

