  /**
   * Asynchronously fulfills the request without a {@link ImageView} or {@link Target}. This is
   * useful when you want to warm up the cache with an image.
   * <p>
   * <em>Note:</em> It is safe to invoke this method from any thread.
   */
  public void fetch() {
    long started = System.nanoTime();

    if (deferred) {
      throw new IllegalStateException("Fit cannot be used with fetch.");
    }
    if (data.hasImage()) {
      Request request = createRequest(started);
      String key = createKey(request, new StringBuilder());

      Action action = new FetchAction(picasso, request, skipMemoryCache, key);
      picasso.submit(action);
    }
  }

