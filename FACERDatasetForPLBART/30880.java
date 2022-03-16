    @Test
    public void testGetCitysUseCase() throws Exception {
        assertNotNull(mUseCase);
        TestSubscriber<List<CityEntity>> testSubscriber = TestSubscriber.create(new GetCitysUseCaseDelegate());
        mUseCase.execute(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        //testSubscriber.assertError(Exception.class);
        testSubscriber.assertNoErrors();
    }

