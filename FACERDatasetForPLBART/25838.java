    @Override
    protected void initDataObserver() {

        mWeatherModel.getGetWeatherStatus().observe(this, new Observer<StatusDataResource.Status>() {
            @Override
            public void onChanged(@Nullable StatusDataResource.Status status) {
                onMoreInfo(mWeatherModel.getAqiData(),mWeatherModel.getDailyData(),mWeatherModel.getLifeIndexData());
            }
        });
    }

