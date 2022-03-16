	@SmallTest
	public void testQueriesOnCityWeatherUri_noTestDataInserted() {
		Cursor cursor = mockContentResolver.query(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS, null, null,
				null, null);
		int actualRowCount = cursor.getCount();
		int expectedRowCount = InitialCity.getInitialCityCount();

		assertEquals("No data inserted so far, but the cursor has "
				+ actualRowCount + " rows", expectedRowCount, actualRowCount);
	}

