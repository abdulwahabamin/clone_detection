  /**
   * Create new downloader that uses OkHttp. This will install an image cache into your application
   * cache directory.
   */
  public OkHttpDownloader(final Context context) {
    this(Utils.createDefaultCacheDir(context));
  }

