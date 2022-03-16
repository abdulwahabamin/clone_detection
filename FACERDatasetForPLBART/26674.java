    private void setWeatherIcon(int actualId, long sunrise, long sunset){
    	int id = actualId / 100;
    	String icon = "";
    	if(actualId == 800){
    		long currentTime = new Date().getTime();
    		if(currentTime>=sunrise && currentTime<sunset) {
    			icon = getActivity().getString(R.string.weather_sunny);
    		} else {
    			icon = getActivity().getString(R.string.weather_clear_night);
    		}
    	} else {
	    	switch(id) {
	    	case 2 : icon = getActivity().getString(R.string.weather_thunder);
			 		 break;     	
	    	case 3 : icon = getActivity().getString(R.string.weather_drizzle);
			 		 break;    	
	    	case 7 : icon = getActivity().getString(R.string.weather_foggy);
	    			 break;
	    	case 8 : icon = getActivity().getString(R.string.weather_cloudy);
			 		 break;
	    	case 6 : icon = getActivity().getString(R.string.weather_snowy);
			 		 break;
	    	case 5 : icon = getActivity().getString(R.string.weather_rainy);
	    			 break;
	    	}
    	}
    	weatherIcon.setText(icon);
    }

