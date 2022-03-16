    private void renderWeather(Info jsonObj) {
        try {
            json0 = jsonObj.day;
            json1 = jsonObj.fort;
            tc = json0.getMain().getTemp();
            preferences.setLatitude((float) json1.getCity().getCoord().getLatitude());
            preferences.setLongitude((float) json1.getCity().getCoord().getLongitude());
            if (citys == null)
                preferences.setCity(json1.getCity().getName() + "," + json0.getSys().getCountry());
            int a = (int) Math.round(json0.getMain().getTemp());
            final String city = json1.getCity().getName().toUpperCase(Locale.US) +
                    ", " +
                    json1.getCity().getCountry();
            cityField.setText(city);
            cityField.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Snack.make(v, city, Snackbar.LENGTH_SHORT);
                }
            });
            List<WeatherFort.WeatherList> details = json1.getList();
            for (int i = 0; i < 10; ++i) {
                details.set(i, json1.getList().get(i));
            }
            HorizontalAdapter horizontalAdapter = new HorizontalAdapter(details);
            horizontalRecyclerView.setAdapter(horizontalAdapter);
            boolean timeFormat24Hours = preferences.isTimeFormat24Hours();
            final String d1 = new java.text.SimpleDateFormat(timeFormat24Hours ? "kk:mm" : "hh:mm a", Locale.US).format(new Date(json0.getSys().getSunrise() * 1000));
            final String d2 = new java.text.SimpleDateFormat(timeFormat24Hours ? "kk:mm" : "hh:mm a", Locale.US).format(new Date(json0.getSys().getSunset() * 1000));
            sunriseView.setText(d1);
            sunsetView.setText(d2);
            DateFormat df = DateFormat.getDateTimeInstance();
            String updatedOn = "Last update: " + df.format(new Date(json0.getDt() * 1000));
            updatedField.setText(updatedOn);
            final String humidity = getString(R.string.humidity_, json0.getMain().getHumidity());
            final String humidity1 = getString(R.string.humidity, json0.getMain().getHumidity());
            humidityView.setText(humidity);
            humidityIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snack.make(rootView, humidity1, Snackbar.LENGTH_SHORT);
                }
            });
            humidityView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snack.make(rootView, humidity1, Snackbar.LENGTH_SHORT);
                }
            });
            final String wind = getString(R.string.wind, json0.getWind().getSpeed(), PreferenceManager.getDefaultSharedPreferences(getContext()).getString(Constants.PREF_TEMPERATURE_UNITS, Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.mps) : getString(R.string.mph));
            final String wind1 = getString(R.string.wind_, json0.getWind().getSpeed(), PreferenceManager.getDefaultSharedPreferences(getContext()).getString(Constants.PREF_TEMPERATURE_UNITS, Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.mps) : getString(R.string.mph));
            windView.setText(wind);
            directionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snack.make(rootView, wind1, Snackbar.LENGTH_SHORT);
                }
            });
            windView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snack.make(rootView, wind1, Snackbar.LENGTH_SHORT);
                }
            });
            weatherIcon.setText(Utils.setWeatherIcon(context(), json0.getWeather().get(0).getId()));
            weatherIcon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        String rs = json0.getWeather().get(0).getDescription();
                        String[] strArray = rs.split(" ");
                        StringBuilder builder = new StringBuilder();
                        for (String s : strArray) {
                            String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
                            builder.append(cap.concat(" "));
                        }
                        Snack.make(v, getString(R.string.hey_there_condition, builder.toString().substring(0, builder.length() - 1)), Snackbar.LENGTH_SHORT);
                    } catch (Exception e) {
                        Log.e("Error", "Main Weather Icon OnClick Details could not be loaded");
                    }
                }
            });
            String r1 = Integer.toString(a) + "°";
            button.setText(r1);
            int deg = json0.getWind().getDirection();
            setDeg(deg);
        } catch (Exception e) {
            Log.e(WeatherFragment.class.getSimpleName(), "One or more fields not found in the JSON data");
        }
    }

