	@Override
	protected void setUp() throws Exception {
		super.setUp();

		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				WeatherInfoActivity.class);
		intent.putExtra(TEST_WEATHER_INFO_TYPE_KEY,
				(Parcelable) TEST_WEATHER_INFO_TYPE_VALUE);
		intent.putExtra(TEST_JSON_STRING_KEY,
				GlobalConstants.TEST_JSON_STRING_VALUE);
		startActivity(intent, null, null);

		weatherInfoActivity = getActivity();
		isDualPane = WeatherInfoActivity.DUAL_PANE.equals(weatherInfoActivity
				.getString(R.string.weather_info_frame_layout_pane_number_tag));
	}

