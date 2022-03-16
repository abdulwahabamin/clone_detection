        @Override
        protected Void doInBackground(String... params) {
            try {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
                String language = Language.getOwmLanguage();
                String apiKey = sp.getString("apiKey", context.getResources().getString(R.string.apiKey));
                URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?id=" + URLEncoder.encode(sp.getString("cityId", Constants.DEFAULT_CITY_ID), "UTF-8") + "&lang="+ language +"&mode=json&appid=" + apiKey);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader connectionBufferedReader = null;
                try {
                    connectionBufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    if (urlConnection.getResponseCode() == 200) {
                        StringBuilder result = new StringBuilder();
                        String line;
                        while ((line = connectionBufferedReader.readLine()) != null) {
                            result.append(line).append("\n");
                        }
                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                        editor.putString("lastLongterm", result.toString());
                        editor.apply();
                    } else {
                        // Connection problem
                    }
                } finally {
                    if (connectionBufferedReader != null) connectionBufferedReader.close();
                }
            } catch (IOException e) {
                // No connection
            }
            return null;
        }

