    @Override
    public void getAirNow(final String location) {
        HeWeather.getAirNow(context, location, lang, unit, new HeWeather.OnResultAirNowBeansListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.i("sky", "getAirNow onError: ");
                getParentAir(location);
            }

            @Override
            public void onSuccess(AirNow list) {
                if (Code.OK.getCode().equalsIgnoreCase(list.getStatus())) {
                    weatherInterface.getAirNow(list);
                    SpUtils.saveBean(context, "airNow", list);
                }
            }
        });
    }

