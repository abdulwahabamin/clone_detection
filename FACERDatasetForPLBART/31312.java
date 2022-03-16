    private ServicesManager() {
        List<Protocol> protocols = new ArrayList<Protocol>();
        protocols.add(Protocol.HTTP_1_1);
        protocols.add(Protocol.HTTP_2);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.protocols(protocols);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.WEATHER_BASE_URL)
                .client(builder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        weatherInfoService = retrofit.create(WeatherInfoService.class);

        mNameMap.put("CN10101", "北京");
        mNameMap.put("CN10102", "上海");
        mNameMap.put("CN10103", "天津");
        mNameMap.put("CN10104", "�?庆");
        mNameMap.put("CN10132", "香港");
        mNameMap.put("CN10133", "澳门");
    }

