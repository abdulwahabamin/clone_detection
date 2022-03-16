    private boolean haveCityYet(CityWithWeather cityWithWeather) {
        for (CityWithWeather city : mCities) {
            if (city.getCity().get_id().equals(cityWithWeather.getCity().get_id())) {
                return true;
            }
        }
        return false;
    }

