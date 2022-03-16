    public void addCity(CityWithWeather city) {
        if (!haveCityYet(city)) {
            mCities.add(mCities.size(), city);
            notifyItemChanged(mCities.size());
        }
    }

