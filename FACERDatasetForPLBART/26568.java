    public void UpdateData(Boolean notification){
        /**
         * Writing data to TextView
         */
        loc.setText(WeatherHelper.getCity());
        temp.setText(String.format("%.1f", WeatherHelper.getTemperature_max()) + "°");
        desc.setText(WeatherHelper.getDescription());
        windspeed.setText(WeatherHelper.getSpeed().toString() + " km/h");
        hum.setText(WeatherHelper.getHumidity().toString() + "%");
        press.setText(WeatherHelper.getPressure().toString() + " mBar");
        tomorrow_temp.setText(String.format("%.1f", WeatherHelper.getTomorrow_temp()) + "°");
        tomorrow_desc.setText(WeatherHelper.getTomorrow_desc());
        //Integer t = WeatherHelper.getSunrise();
        //sunr.setText(WeatherHelper.convertTime(t) + " Uhr");
        //suns.setText(WeatherHelper.convertTime(WeatherHelper.getSunset().toString()) + " Uhr");
        /**
         * Setting Sun/Cloud/... Image from converted weather id
         */
        card.setCardBackgroundColor(getResources().getColor(WeatherHelper.convertWeatherToColor(WeatherHelper.getWeatherId())));
        card_tomorrow.setCardBackgroundColor(getResources().getColor(WeatherHelper.convertWeatherToColor(WeatherHelper.getTomorrowWeatherId())));
        todayStat.setImageResource(WeatherHelper.convertWeather(WeatherHelper.getWeatherId()));
        tomorrowStat.setImageResource(WeatherHelper.convertWeather(WeatherHelper.getTomorrowWeatherId()));
        if(notification){
            sendNotification();
        }
        if(mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

