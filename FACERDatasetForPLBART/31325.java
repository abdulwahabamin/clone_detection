    @Test
    public void testServicesManagerGetWeatherConditions() throws Exception {
        assertNotNull(mServicesManger);
        TestSubscriber<List<WeatherConditionEntity>> testSubscriber = TestSubscriber.create(new GetWeatherConditionsDelegate());
        mServicesManger.getWeatherConditionEntities().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();

        /*final Logger logger = Logger.getLogger("testServicesManagerGetWeatherConditions");
        assertNotNull(mServicesManger);
        mServicesManger.getWeatherConditions()
                .subscribe(new Subscriber<List<WeatherConditionEntity>>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                    }

                    @Override
                    public void onNext(List<WeatherConditionEntity> weatherConditionEntities) {
                        logger.info("onNext");
                        mWeatherConditions = weatherConditionEntities;
                        for (WeatherConditionEntity condition :
                                weatherConditionEntities) {
                            logger.info(condition.toString());
                        }
                    }
                });
        assertNotNull(mWeatherConditions);
        assertFalse(mWeatherConditions.isEmpty());*/
    }

