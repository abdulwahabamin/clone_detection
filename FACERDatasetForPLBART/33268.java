	/**
	 * Sets up the test environment before each test method. Creates a mock
	 * content resolver, gets the provider under test, and creates a new
	 * database for the provider.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mockContentResolver = getMockContentResolver();

		/*
		 * Gets a handle to the database underlying the provider. Gets the
		 * provider instance created in super.setUp(), gets the
		 * DatabaseOpenHelper for the provider, and gets a database object from
		 * the helper.
		 */
		sqLiteDatabase = getProvider().getOpenHelperForTest()
				.getWritableDatabase();
	}

