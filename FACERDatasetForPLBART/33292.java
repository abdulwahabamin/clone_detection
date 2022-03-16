	@SmallTest
	public void testLayoutContainsWeatherInfoContainer() {
		int weatherInfoContainerFrameLayoutId = R.id.weather_info_container;
		FrameLayout weatherInfoContainer = (FrameLayout) weatherInfoActivity
				.findViewById(weatherInfoContainerFrameLayoutId);

		if (isDualPane) {
			assertNull(weatherInfoContainer);
		} else {
			assertNotNull(weatherInfoContainer);
		}
	}

