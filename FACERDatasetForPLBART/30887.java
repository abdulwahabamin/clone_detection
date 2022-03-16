    @Test
    public void testGetWeatherConditionsUseCase() throws Exception {
        assertNotNull(mUseCase);
        TestSubscriber<List<WeatherConditionEntity>> testSubscriber = TestSubscriber.create(new GetWeatherConditionsUseCaseDelegate());
        mUseCase.execute(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
    }

