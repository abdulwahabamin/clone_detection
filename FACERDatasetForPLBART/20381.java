  /**
   * Create a new downloader that uses the specified OkHttp instance. A response cache will not be
   * automatically configured.
   */
  public OkHttpDownloader(OkHttpClient client) {
    this.urlFactory = new OkUrlFactory(client);
  }

