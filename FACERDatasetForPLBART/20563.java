  static Downloader createDefaultDownloader(Context context) {
    boolean okUrlFactory = false;
    try {
      Class.forName("com.squareup.okhttp.OkUrlFactory");
      okUrlFactory = true;
    } catch (ClassNotFoundException ignored) {
    }

    boolean okHttpClient = false;
    try {
      Class.forName("com.squareup.okhttp.OkHttpClient");
      okHttpClient = true;
    } catch (ClassNotFoundException ignored) {
    }

    if (okHttpClient != okUrlFactory) {
      throw new RuntimeException(""
          + "Picasso detected an unsupported OkHttp on the classpath.\n"
          + "To use OkHttp with this version of Picasso, you'll need:\n"
          + "1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n"
          + "2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\n"
          + "Note that OkHttp 2.0.0+ is supported!");
    }

    return okHttpClient
        ? OkHttpLoaderCreator.create(context)
        : new UrlConnectionDownloader(context);
  }

