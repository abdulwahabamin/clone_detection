	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);  
	    //weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");     
	    weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "weather.ttf");     
	    updateWeatherData(new CityPreference(getActivity()).getCity());
	}

