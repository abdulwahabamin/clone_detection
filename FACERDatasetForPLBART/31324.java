    @Test
    public void testServicesManagerGetCitys() throws Exception {
        assertNotNull(mServicesManger);
        TestSubscriber<List<CityEntity>> testSubscriber = TestSubscriber.create(new GetCitysDelegate());
        mServicesManger.getCityEntities().subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();

        /*final Logger logger = Logger.getLogger("testServicesManagerGetCitys");
        assertNotNull(mServicesManger);
        mServicesManger.getCitys()
                .subscribe(new Subscriber<List<CityEntity>>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        logger.info("onNext");
                        mCitys = cityEntities;
                        for (CityEntity city :
                                cityEntities) {
                            logger.info(city.toString());
                        }
                    }
                });
        assertNotNull(mCitys);
        assertFalse(mCitys.isEmpty());*/
    }

