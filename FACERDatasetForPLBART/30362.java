    @Override
    public void getWeatherNow(String location) {
        HeWeather.getWeatherNow(context, location, lang, unit, new HeWeather.OnResultWeatherNowBeanListener() {
            @Override
            public void onError(Throwable throwable) {
                Now weatherNow = SpUtils.getBean(context, "weatherNow", Now.class);
                weatherInterface.getWeatherNow(weatherNow);
            }

            @Override
            public void onSuccess(Now list) {
                if (Code.OK.getCode().equalsIgnoreCase(list.getStatus())) {
                    weatherInterface.getWeatherNow(list);
                    SpUtils.saveBean(context, "weatherNow", list);
                }
            }
        });

    }

