    @Provides
    @PerApplication
    IOpenWeatherMapApi providesOpenWeatherMapApi(Retrofit retrofit) {

        return retrofit.create(IOpenWeatherMapApi.class);
    }

