    @Provides
    @Singleton
    Retrofit providesRestAdapter(OkHttpClient okHttpClient, Gson gson) {

        return new Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

