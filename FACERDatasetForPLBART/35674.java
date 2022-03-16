    public NetService init(String baseurl, Map<String, String> headers) {
        synchronized (this) {
            headerInterceptor = new HeaderInterceptor(headers);
            okHttpClient = new OkHttpClient.Builder().
                    readTimeout(15, TimeUnit.SECONDS).
                    writeTimeout(10, TimeUnit.SECONDS).
                    connectTimeout(10, TimeUnit.SECONDS).
                    addInterceptor(loggingInterceptor).
                    addInterceptor(headerInterceptor).
                    build();

            retrofit = new Retrofit.Builder().
                    addConverterFactory(ScalarsConverterFactory.create()).
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                    baseUrl(baseurl).
                    client(okHttpClient).
                    build();
            downLoadService = create(IDownLoadService.class);

        }
        return this;
    }

