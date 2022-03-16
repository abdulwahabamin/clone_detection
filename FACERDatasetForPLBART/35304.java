    private HWeather getCityData(){
        String cityName = mRepository.getShowCity();
        try {
            return mRepository.getLocalWeather(cityName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

