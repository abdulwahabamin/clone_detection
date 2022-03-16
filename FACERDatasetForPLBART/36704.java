	public void updateCurrentWeatherDisplay(){
		TextView PubDateTextView, LocationTextView;
		TextView TempDescTextView, HumidBaroTextView, DewpointTextView, WindSpdDirTextView, 
		 	WindChillHeatIndxTextView, VisibilityTextView;
		ImageView ConditionIconImageView;

		SimpleDateFormat CurrentDateTimeDisplayFormat = new SimpleDateFormat("EEEE yyyy-MM-dd HH:mm");
		
		PubDateTextView = (TextView) findViewById(R.id.PubDateTextView);
		PubDateTextView.setText((CharSequence)wo.getPub_date());
		
		LocationTextView = (TextView) findViewById(R.id.LocationTextView);
		LocationTextView.setText((CharSequence)wo.getLocation());
		
		TempDescTextView = (TextView) findViewById(R.id.ccTempDescTextView);
		TempDescTextView.setText((CharSequence)wo.getTemperature() + " " + wo.getDescription());
		
		HumidBaroTextView = (TextView) findViewById(R.id.ccHumidBaroTextView);
		HumidBaroTextView.setText("Humidity: " + (CharSequence)wo.getHumidity() + " Pressure: " + wo.getBarometer());
		
		DewpointTextView = (TextView) findViewById(R.id.ccDewpointTextView);
		DewpointTextView.setText("Dewpoint: " + (CharSequence)wo.getDewpoint());
		
		WindSpdDirTextView = (TextView) findViewById(R.id.ccWindSpdDirTextView);
		WindSpdDirTextView.setText("Wind: " + (CharSequence)wo.getWind_speed() + " " + wo.getWind_direction());
		
		WindChillHeatIndxTextView = (TextView) findViewById(R.id.ccWindChillHeatIndxTextView);
		WindChillHeatIndxTextView.setText("Wind Chill: " + (CharSequence)wo.getWind_chill() + " Heat Index: " + wo.getHeat_index());
		
		VisibilityTextView = (TextView) findViewById(R.id.ccVisibilityTextView);
		VisibilityTextView.setText("Visibility: " + (CharSequence)wo.getVisibility());
	}

