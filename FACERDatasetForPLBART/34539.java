    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEARCH_CITY_CODE) {
            if (resultCode == RESULT_OK) {
                final String cityId = data.getExtras().getString(SEARCH_CITY_KEY);
                if (gMyCities != null ) {
                    for(MyCity myCity : gMyCities){
                        if(myCity.cityId.equals(cityId)){
                            toast("该城市已存在");
                            return;
                        }
                    }
                }
                Log.d("weather", "  cityId = " + cityId);
                weatherService.pick(cityId, new Action1<WeatherBuilder>() {
                    @Override
                    public void call(WeatherBuilder weatherBuilder) {
                        weatherService.addMyCity(cityId);
                        final WeatherData weatherData = weatherBuilder.build();
                        Log.d("weather", "  weatherData = " + weatherData.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                weatherAdaper.addWeatherData(weatherData);
                            }
                        });
                    }
                });
            }
        }
    }

