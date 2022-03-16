    public synchronized static LocationNetworkSourcesService getInstance() {
        if (instance == null) {
            instance = new LocationNetworkSourcesService();
        }
        return instance;
    }

