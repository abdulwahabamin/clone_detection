    @Override
    public Weather call() throws Exception {
        Weather weather = null;
        String data = ((new HTTPWeatherClient()).getWeatherData(location));

        try {
            weather = JSONWeatherParser.getWeather(data);
            Bitmap icon = HTTPWeatherClient.getResizedBitmap(
                    HTTPWeatherClient.getBitmapFromURL(weather.getCurrentCondition().getIcon()),
                    100,
                    100);
            weather.setIcon(icon);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weather;
    }

