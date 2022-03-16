    @Override
    public void refreshData() {
        mCityRepository.getLoveCity(new CityDataSource.GetLoveCityCallBack() {
            @Override
            public void onSuccess(final List<LoveCityEntity> loveCities) {
                ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
                for (int i = 0; i < loveCities.size(); i++) {
                    final int index = i;
                    singleThreadExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mWeatherRepository.updateCityWeather(loveCities.get(index).getCityName());
                                if (index == 0) {
                                    loadWeather();
                                    updateDataInWeeks();
                                }
                            } catch (Exception e) {
                                MainThreadAction.getInstance().post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mView.setNetWork();
                                    }
                                });
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(String failureMessage) {
                LoveCityEntity entity = new LoveCityEntity(null, "æˆ?éƒ½", 1);
                mCityRepository.addLoveCity(entity);
                refreshData();
            }
        });
    }

