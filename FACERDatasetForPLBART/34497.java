    private HeWeatherPickerImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HeWeatherREST.HE_WEATHER_API).addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .build();
        heWeatherREST = retrofit.create(HeWeatherREST.class);
    }

