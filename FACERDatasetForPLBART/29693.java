  /**
   * @return retrofit instance {@link Retrofit}
   */
  public static Retrofit getClient() {

    if (okHttpClient == null)
      initOkHttp();

    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(Constants.BASE_URL)
          .client(okHttpClient)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

