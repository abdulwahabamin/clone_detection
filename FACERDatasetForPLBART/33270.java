	/**
	 * Tests the provider's publicly available URIs. If the URI is not one that
	 * the provider understands, the provider should throw an exception. It also
	 * tests the provider's getType() method for each URI, which should return
	 * the MIME type associated with the URI.
	 */
	@SmallTest
	public void testUriAndGetType() {
		String mimeType = mockContentResolver
				.getType(WeatherContentProvider.CONTENT_URI_CITY_RECORDS);
		assertEquals(
				"mockContentResolver returned incorrect MIME type for the city table URI",
				WeatherContentProvider.CONTENT_TYPE_CITY_RECORDS, mimeType);

		// Creates a test URI with a pattern for city row ids. (The id doesn't
		// have to exist.)
		Uri noteIdUri = ContentUris.withAppendedId(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS, 1);

		mimeType = mockContentResolver.getType(noteIdUri);
		assertEquals(
				"mockContentResolver returned incorrect MIME type for the city table row URI",
				WeatherContentProvider.CONTENT_ITEM_TYPE_CITY_RECORDS, mimeType);

		mimeType = mockContentResolver.getType(INVALID_URI);
		assertNull("MIME type for invalid URI should be null", mimeType);
	}

