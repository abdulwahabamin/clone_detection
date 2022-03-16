	@SmallTest
	public void testPreConditions() {
		assertNotNull("Instance of WeatherInfoActivity is null",
				weatherInfoActivity);
		assertNotNull("WeatherInfoActivity's action bar is null",
				weatherInfoActivity.getSupportActionBar());
	}

