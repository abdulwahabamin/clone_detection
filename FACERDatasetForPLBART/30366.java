    private void getParentAir(String location) {
        HeWeather.getSearch(context, location, "cn,overseas", 3, lang, new HeWeather.OnResultSearchBeansListener() {
            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onSuccess(Search search) {
                String parentCity = search.getBasic().get(0).getParent_city();
                if (TextUtils.isEmpty(parentCity)) {
                    parentCity = search.getBasic().get(0).getAdmin_area();
                }
                HeWeather.getAirNow(context, parentCity, lang, unit, new HeWeather.OnResultAirNowBeansListener() {
                    @Override
                    public void onError(Throwable throwable) {
                        weatherInterface.getAirNow(null);
                    }

                    @Override
                    public void onSuccess(AirNow airNow) {
                        if (Code.OK.getCode().equalsIgnoreCase(airNow.getStatus())) {
                            weatherInterface.getAirNow(airNow);
                        }
                    }
                });
            }
        });
    }

