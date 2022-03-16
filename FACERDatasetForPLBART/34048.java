        @Override
        protected Void doInBackground(String... params) {
            String lat = params[0];
            String lon = params[1];

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            String language = Language.getOwmLanguage();
            String apiKey = sp.getString("apiKey", context.getResources().getString(R.string.apiKey));

            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=&lat=" + lat + "&lon=" + lon + "&lang="+ language +"&appid=" + apiKey);
                Log.d(TAG, "Request: " + url.toString());

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200) {
                    BufferedReader connectionBufferedReader = null;
                    try {
                        connectionBufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder result = new StringBuilder();
                        String line;
                        while ((line = connectionBufferedReader.readLine()) != null) {
                            result.append(line).append("\n");
                        }
                        Log.d(TAG, "JSON Result: " + result);
                        JSONObject reader = new JSONObject(result.toString());
                        String cityId = reader.getString("id");
                        String city = reader.getString("name");
                        String country = "";
                        JSONObject countryObj = reader.optJSONObject("sys");
                        if (countryObj != null) {
                            country = ", " + countryObj.getString("country");
                        }
                        Log.d(TAG, "City: " + city + country);
                        String lastCity = PreferenceManager.getDefaultSharedPreferences(context).getString("city", "");
                        String currentCity = city + country;
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("cityId", cityId);
                        editor.putString("city", currentCity);
                        editor.putBoolean("cityChanged", !currentCity.equals(lastCity));
                        editor.commit();

                    } catch (JSONException e){
                        Log.e(TAG, "An error occurred while reading the JSON object", e);
                    } finally {
                        if (connectionBufferedReader != null) connectionBufferedReader.close();
                    }
                } else {
                    Log.e(TAG, "Error: Response code " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e(TAG, "Connection error", e);
            }
            return null;
        }

