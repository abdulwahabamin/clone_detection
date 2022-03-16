    @Test
    public void testServicesManagerGetCityWeather() throws Exception {
        assertNotNull(mServicesManger);
        TestSubscriber<WeatherEntity> testSubscriber = TestSubscriber.create(new GetCityWeatherDelegate());
        mServicesManger.getCityWeather("CN101010300", false).subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();

        /*final Logger logger = Logger.getLogger("testServicesManagerGetCityWeather");
        assertNotNull(mServicesManger);
        mServicesManger.getCityWeather("CN101010300")
                .subscribe(new Subscriber<WeatherEntity>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                        logger.info(e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherEntity weatherEntity) {
                        logger.info("onNext");
                        mWeatherEntity = weatherEntity;
                        logger.info(mWeatherEntity.toString());
                    }
                });
        assertNotNull(mWeatherEntity);*/
    }

