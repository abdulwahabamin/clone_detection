        @Override
        protected Void doInBackground(String... params) {
            try {
                Prefs prefs = new Prefs(context);
                WeatherInfo weatherInfo = new Request(context).getItems(prefs.getCity() , prefs.getUnits());
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
                sp.edit().putString("lastToday" , new Gson().toJson(weatherInfo , WeatherInfo.class)).apply();
            }
            catch (IOException e) {
                // No connection
            }
            return null;
        }

