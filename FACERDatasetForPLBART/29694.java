  /**
   * init instance of {@link OkHttpClient}
   */
  private static void initOkHttp() {
    OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
        .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    //httpClient.addInterceptor(interceptor);

    httpClient.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json");

        Request request = requestBuilder.build();
        return chain.proceed(request);
      }
    });

    okHttpClient = httpClient.build();
  }

