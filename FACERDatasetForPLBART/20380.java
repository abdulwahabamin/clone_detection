  /**
   * Create new downloader that uses OkHttp. This will install an image cache into your application
   * cache directory.
   *
   * @param cacheDir The directory in which the cache should be stored
   * @param maxSize The size limit for the cache.
   */
  public OkHttpDownloader(final File cacheDir, final long maxSize) {
    this(new OkHttpClient());
    try {
      urlFactory.client().setCache(new com.squareup.okhttp.Cache(cacheDir, maxSize));
    } catch (IOException ignored) {
    }
  }

