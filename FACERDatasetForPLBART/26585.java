    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        Toast.makeText(getBaseContext(), "Loading Callback", Toast.LENGTH_LONG).show();
        getWeatherData();
        /*nh.Notificate(
                this,
               "lol in " + city + ", " + countrycode,
                "Xd",
                "Wettervorhersage",
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher);*/
        return Service.START_STICKY;
    }

