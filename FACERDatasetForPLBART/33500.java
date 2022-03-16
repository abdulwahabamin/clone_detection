    /**
     * A test package can call this to get a handle to the database underlying
     * WeatherContentProvider, so it can insert test data into the database. The test case class
     * is responsible for instantiating the provider in a test context;
     * {@link android.test.ProviderTestCase2} does this during the call to setUp()
     *
     * @return a handle to the database helper object for the provider's data.
     */
    public DatabaseHelper getOpenHelperForTest() {
        return databaseHelper;
    }

