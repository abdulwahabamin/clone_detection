    public void getCurrentWeatherData(String apiKey, String query) {
        if(apiKey != null) {
            try {
                String url = buildUrl(apiKey, mode, query);
                new DownloadCurrentData().execute(url);
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
            }
        } else {
            Log.e(LOG_TAG, "ApiKey cannot be null");
        }
    }

