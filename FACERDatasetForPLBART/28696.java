    public void addCity() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                if (selectedCity != null){
                    database.addCityToWatch(new CityToWatch(
                            15,
                            selectedCity.getPostalCode(),
                            selectedCity.getCountryCode(),
                            -1,
                            selectedCity.getCityId(),
                            selectedCity.getCityName()
                    ));
                    prefManager.setDefaultLocation(selectedCity.getCityId());
                    Intent intent = new Intent(getApplicationContext(), UpdateDataService.class);
                    intent.setAction(UpdateDataService.UPDATE_CURRENT_WEATHER_ACTION);
                    startService(intent);
                }

                return null;
            }
        }.doInBackground();
    }

