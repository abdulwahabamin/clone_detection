    public synchronized static NominatimLocationService getInstance() {
        if (instance == null) {
            instance = new NominatimLocationService();
            try {
                formatter = new Formatter();
            } catch (IOException e) {
                Log.w(TAG, "Could not initialize address formatter", e);
            }
            client.addHeader("User-Agent", String.format("YourLocalWeather/%s (Linux; Android %s)", VERSION_NAME, RELEASE));
        }
        return instance;
    }

