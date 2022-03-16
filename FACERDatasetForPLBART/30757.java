    @Inject
    public DataManager(IOpenWeatherMapApi openWeatherMapService, DatabaseHelper databaseHelper) {

        this.openWeatherMapService = openWeatherMapService;
        this.databaseHelper = databaseHelper;
        memoryCache = new MemoryCache();
    }

