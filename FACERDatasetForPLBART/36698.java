    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // String zipCodeJSONURL = "http://maps.google.com/maps/geo?ll=" + 37.775,-122.4183333
        String zipCodeJSONURL = "http://maps.google.com/maps/geo?ll=" + getLocationCoordinates();
        // locCoordinatesToZipCode
        String zipCode = "02130";
		
		URL weatherURL = null;
		try {
			weatherURL = new URL("http", "www.rssweather.com", "/zipcode/" + zipCode + "/rss.php");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) weatherURL.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			RSSHandler handler = new RSSHandler();
			parser.parse(urlConnection.getInputStream(), handler);
			myMessageList = handler.getMessages();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		for (Message msg: myMessageList){
			// check category info to see how to process the information
			if (msg.getCategory().equals("Current Conditions")){
				processCurrentConditions(msg);
			}
			else if (msg.getCategory().equals("Weather Forecast")){
				processWeatherForecast(msg);
			}
		}
		
		if (wo != null) {
			updateCurrentWeatherDisplay();
			updateWeatherForecastDisplay();
			
		}
		else {
			Log.v("WeatherAPP", "wo empty again...");
		}
    }

