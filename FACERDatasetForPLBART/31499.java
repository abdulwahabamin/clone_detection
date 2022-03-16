    @Override
    public void updateUpdateService(String cityId) {
        // 更新WeatherUpdateService的城市
        Intent intent = new Intent(getApplicationContext(), WeatherUpdateService.class);
        intent.putExtra(WeatherUpdateService.UPDATE_CITY_ID, cityId);
        startService(intent);
    }

