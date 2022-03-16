    private void addLocationForNewCity(final City selectedCity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                boolean isAdded = database.isCityWatched(selectedCity.getCityId());

                if (!isAdded) {
                    CityToWatch newCity = new CityToWatch();
                    newCity.setCityId(selectedCity.getCityId());
                    newCity.setRank(42);

                    database.addCityToWatch(newCity);

                    Intent intent = new Intent(getApplicationContext(), UpdateDataService.class);
                    intent.setAction(UpdateDataService.UPDATE_CURRENT_WEATHER_ACTION);
                    intent.putExtra("cityId", selectedCity.getCityId());
                    startService(intent);
                }

                return null;
            }

        }.doInBackground();
    }

