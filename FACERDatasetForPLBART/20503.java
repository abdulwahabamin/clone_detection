  /**
   * Synchronously fulfill this request. Must not be called from the main thread.
   * <p>
   * <em>Note</em>: The result of this operation is not cached in memory because the underlying
   * {@link Cache} implementation is not guaranteed to be thread-safe.
   */
  public Bitmap get() throws IOException {
    long started = System.nanoTime();
    checkNotMain();

    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with get.");
    }
    if (!data.hasImage()) {
      return null;
    }

    Request finalData = createRequest(started);
    String key = createKey(finalData, new StringBuilder());

    Action action = new GetAction(picasso, finalData, skipMemoryCache, key);
    return forRequest(picasso.context, picasso, picasso.dispatcher, picasso.cache, picasso.stats,
        action, picasso.dispatcher.downloader).hunt();
  }

