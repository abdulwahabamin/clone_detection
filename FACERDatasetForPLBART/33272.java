	@MediumTest
	public void testQueriesOnCityWeatherUri_testDataInserted() {
		insertInitialTestData();

		Cursor cursor = mockContentResolver.query(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS, null, null,
				null, null);
		int actualRowCount = cursor.getCount();
		int expectedRowCount = InitialCity.getInitialCityCount()
				+ TEST_DATA.length;

		assertEquals("Inserted the initial " + expectedRowCount
				+ " records, but the cursor has " + actualRowCount + " rows",
				expectedRowCount, actualRowCount);
	}

