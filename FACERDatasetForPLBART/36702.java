	public void processCurrentConditions(Message m){
		// pick apart the content field from wo

		props.setPruneTags("dt");
		
		String title = m.getTitle();
		
		wo.setPub_date(m.getDate());
		wo.setLocation(title.substring(0, title.indexOf("Weather")));
		
		TagNode node = cleaner.clean(m.getContent());
		
		wo.setTemperature(node.findElementByAttValue("class", "temp", true, false).getText().toString().replaceAll("&#176;", "°"));
		wo.setDescription(node.findElementByAttValue("class", "sky", true, false).getText().toString());
		wo.setHumidity(node.findElementByAttValue("id", "humidity", true, false).getText().toString());
		wo.setWind_speed(node.findElementByAttValue("id", "windspeed", true, false).getText().toString());
		wo.setWind_direction(node.findElementByAttValue("id", "winddir", true, false).getText().toString().replaceAll("&#176;", "°"));
		wo.setBarometer(node.findElementByAttValue("id", "pressure", true, false).getText().toString());
		wo.setDewpoint(node.findElementByAttValue("id", "dewpoint", true, false).getText().toString().replaceAll("&#176;", "°"));
		wo.setHeat_index(node.findElementByAttValue("id", "heatindex", true, false).getText().toString().replaceAll("&#176;", "°"));
		wo.setWind_chill(node.findElementByAttValue("id", "windchill", true, false).getText().toString().replaceAll("&#176;", "°"));
		wo.setVisibility(node.findElementByAttValue("id", "visibility", true, false).getText().toString());
	}

