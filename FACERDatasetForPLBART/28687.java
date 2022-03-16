    public void addCity() {
        String postCode = "-";
        try {
            postCode = selectedCity.getPostalCode();
        } catch (NullPointerException e) {

        }

        new AsyncTask<CityToWatch, Void, Void>() {
            @Override
            protected Void doInBackground(CityToWatch... params) {
                database.addCityToWatch(params[0]);
                return null;
            }
        }.doInBackground(new CityToWatch(
                15,
                postCode,
                selectedCity.getCountryCode(),
                -1,
                selectedCity.getCityId(),
                selectedCity.getCityName()
        ));
    }

