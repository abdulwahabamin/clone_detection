    @Override
    public void onRefresh() {
        if (mCity.isAutoLocate) {
            locate();
        } else {
            getWeatherFromNet();
        }
    }

