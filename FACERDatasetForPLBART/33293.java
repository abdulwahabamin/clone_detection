	@SmallTest
	public void testWeatherInfoFragment() {
		if (isDualPane) {
			return;
		}

		FragmentManager fragmentManager = weatherInfoActivity
				.getSupportFragmentManager();
		fragmentManager.executePendingTransactions();

		WeatherCurrentInfoFragment currentInfoFragment = (WeatherCurrentInfoFragment) fragmentManager
				.findFragmentById(R.id.weather_info_container);
		assertNotNull(
				"Weather current info fragment not found in the layout [weather_info_container]",
				currentInfoFragment);

		assertTrue("Weather current info fragment not added",
				currentInfoFragment.isAdded());

		String actualCurrentInfoFragmentsJsonStringArgument = currentInfoFragment
				.getArguments().getString(WeatherInfoFragment.JSON_STRING);
		assertNotNull(
				"WeatherCurrentInfoFragment received null JSON data argument",
				actualCurrentInfoFragmentsJsonStringArgument);
		assertEquals(
				"WeatherCurrentInfoFragment received incorrect JSON data argument:\n"
						+ actualCurrentInfoFragmentsJsonStringArgument,
				GlobalConstants.TEST_JSON_STRING_VALUE,
				actualCurrentInfoFragmentsJsonStringArgument);
	}

