    @Test
    public void testGetCityWeatherUseCase() throws Exception {
        assertNotNull(mUseCase);
        TestSubscriber<WeatherEntity> testSubscriber = TestSubscriber.create(new GetCityWeatherUseCaseDelegate());
        mUseCase.execute(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
    }

