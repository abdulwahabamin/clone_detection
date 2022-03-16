    @Override
    public void getWeatherHourly(String location) {
        HeWeather.getWeatherHourly(context, location, lang, unit, new HeWeather.OnResultWeatherHourlyBeanListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.i("sky", "getWeatherHourly onError: getWeatherHourly");
            }

            @Override
            public void onSuccess(Hourly list) {
                if (Code.OK.getCode().equalsIgnoreCase(list.getStatus())) {
                    weatherInterface.getWeatherHourly(list);
                    SpUtils.saveBean(context, "weatherHourly", list);
                }
            }
        });
    }

