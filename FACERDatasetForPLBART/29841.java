    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        wf.changeCity(city);
        new Prefs(this).setCity(city);
    }

