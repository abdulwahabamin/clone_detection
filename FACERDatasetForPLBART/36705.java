	public void updateWeatherForecastDisplay(){
		ImageView fcIconImageView[] = new ImageView[6];
		TextView fcDateTextView[] = new TextView[6];
		TextView fcDescTextView[] = new TextView[6];
		TextView fcTempTextView[] = new TextView[6];
		TextView fcWindTextView[] = new TextView[6];
		TextView fcPrecipTextView[] = new TextView[6];
		
		for (int x = 0; x < wo.wf.size(); x++){
			fcDateTextView[x] = (TextView) findViewById(fcDateTextViews[x]);
			fcDateTextView[x].setText(wo.wf.get(x).getDate());
			
			fcDescTextView[x] = (TextView) findViewById(fcDescTextViews[x]);
			fcDescTextView[x].setText(wo.wf.get(x).getDescription());
			
			fcTempTextView[x] = (TextView) findViewById(fcTempTextViews[x]);
			fcTempTextView[x].setText(wo.wf.get(x).getTemperature());
			
			fcWindTextView[x] = (TextView) findViewById(fcWindTextViews[x]);
			fcWindTextView[x].setText(wo.wf.get(x).getWind());
			
			fcPrecipTextView[x] = (TextView) findViewById(fcPrecipTextViews[x]);
			fcPrecipTextView[x].setText(wo.wf.get(x).getPrecip_chance());
		}
	}

