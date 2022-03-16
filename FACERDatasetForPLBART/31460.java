    @Override
    public void navigateToCityWeatherActivity(String cityId) {
        Intent intent = new Intent(this, CityWeatherActivity.class);
        intent.putExtra(CityWeatherActivity.CITY_ID, cityId);
        startActivity(intent);
        finish();
    }

