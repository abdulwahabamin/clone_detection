	public void processWeatherForecast(Message m){
		WeatherForecast wf = new WeatherForecast(); 
		StringTokenizer st = new StringTokenizer(m.getDescription(), ".");
		String temp_pattern, wind_pattern, rain_pattern;
		
		StringBuilder description = new StringBuilder();
		StringBuilder wind = new StringBuilder(); 

		wf.setDate(m.getTitle());
		
		temp_pattern = "[lows|highs] in the";
		wind_pattern = "mph"; 
		rain_pattern = "rain";

		while (st.hasMoreElements()){
			String tokenizedString = st.nextToken(); 
			if (tokenizedString.indexOf(wind_pattern) > 0){
				wind.append(tokenizedString);
				wind.append(".");
			}
			else if (tokenizedString.indexOf(rain_pattern) > 0){
				wf.setPrecip_chance(tokenizedString);
			}
			else if (tokenizedString.matches(temp_pattern)){
				wf.setTemperature(tokenizedString);
			}
			else {
				description.append(tokenizedString);
				description.append(".");
			}
		}
		wf.setWind(wind.toString());
		wf.setDescription(description.toString());
		wo.wf.add(wf);
	}

