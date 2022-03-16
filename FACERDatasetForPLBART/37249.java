    private void onLocated(String city) {
        if (TextUtils.isEmpty(city) && TextUtils.equals(mCity.name, "正在定�?")) {
            mCity.name = "北京";
        } else {
            mCity.name = city;
        }
        model.cacheCity(mCity);
        view.setTitle(mCity.name);
        getWeatherFromNet();
    }

