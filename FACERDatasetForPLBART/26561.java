    public void getForecastData(){
        /**
         * Get settings
         */
        String city = prefs.getString("location", "Berlin");
        String CountryCode = prefs.getString("countrykey", "DE");
        String unit = prefs.getString("unitcode", "metric");
        String language = prefs.getString("lang", "de");
        /**
         * Start JSON data download
         */
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + CountryCode + "&units=" + unit + "&lang=" + language, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
                /**
                 * Only for testing
                 */
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                String in = new String(response);
                if (in != "") {
                    WeatherForecastHelper.ParseData(in);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    getForecast();
                } else {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                /**
                 * Called when response HTTP status is "4XX" (eg. 401, 403, 404)
                 * Setting ScrollView's & LoadingLayout's visibility to gone -> displaying the ErrorLayout
                 * TODO Find a better solution for this
                 */
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });
    }

