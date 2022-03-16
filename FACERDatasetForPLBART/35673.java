    public NetService init(String baseUrl) {
        synchronized (this) {
            if (baseUrl.charAt(baseUrl.length() - 1) != '/'){
                baseUrl = baseUrl + "/";
            }
            okHttpClient = new OkHttpClient.Builder().
                    readTimeout(15, TimeUnit.SECONDS).
                    writeTimeout(10, TimeUnit.SECONDS).
                    connectTimeout(10, TimeUnit.SECONDS).
                    addInterceptor(loggingInterceptor).
                    build();

            retrofit = new Retrofit.Builder().
                    addConverterFactory(ScalarsConverterFactory.create()).
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                    baseUrl(baseUrl).
                    client(okHttpClient).
                    build();
            downLoadService = create(IDownLoadService.class);

        }
        return this;
    }

