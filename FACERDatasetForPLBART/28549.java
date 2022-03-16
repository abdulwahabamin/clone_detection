    public void setDefaultLocation(CityToWatch city) {
        prefManager.setDefaultLocation(city.getCityId());
        Toast.makeText(getBaseContext(), getString(R.string.default_location, city.getCityName()) , Toast.LENGTH_SHORT).show();
        //TODO Is there a better nicer solution?
        recreate();
    }

