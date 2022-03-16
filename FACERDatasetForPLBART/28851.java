    public void loadData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                CurrentWeatherData currentWeatherData = PFASQLiteHelper.getInstance(WeatherCityFragment.this.getContext()).getCurrentWeatherByCityId(mCityId);

                if (currentWeatherData.getCity_id() == 0) {
                    currentWeatherData.setCity_id(mCityId);
                }

                mAdapter = new CityWeatherAdapter(currentWeatherData, mDataSetTypes, WeatherCityFragment.this.getContext());

                ((Activity)WeatherCityFragment.this.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setAdapter(mAdapter);
                    }
                });

                return null;
            }
        }.doInBackground();
    }

