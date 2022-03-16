    public void getWeatherData(){
        wh = new WeatherHelper();
        nh = new NotificationHelper();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //String city = settings.getString("city", null);
        //SharedPreferences prefs = this.getSharedPreferences("Location", Context.MODE_PRIVATE);
        city = prefs.getString("location", "Berlin");
        countrycode = prefs.getString("countrykey", "DE");
        unit = prefs.getString("unitcode", "metric");
        langu = prefs.getString("lang", "de");
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + countrycode + "&units=" + unit +"&lang=" + langu, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                String in = new String(response);
                if(in != ""){
                    wh.ParseData(in);
                    noti();
                } else {
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });

    }

