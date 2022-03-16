    @Override
    public void onWeatherDownloadComplete(WeatherData data, WeatherDownloader.Mode mode) {
        if (mode == WeatherDownloader.Mode.CITYNAME) {
            cityNameProgress.setVisibility(View.GONE);
            cityNameResult.setText(String.format("%.2f", WeatherUnits.convertToCelsius(data.getMain().getTemp())));
        } else if (mode == WeatherDownloader.Mode.CITYID) {
            cityIdProgress.setVisibility(View.GONE);
            cityIdResult.setText(String.format("%.2f", WeatherUnits.convertToFahrenheit(data.getMain().getTemp())));
        } else if (mode == WeatherDownloader.Mode.COORDINATES) {
            coordinatesProgress.setVisibility(View.GONE);
            coordinatesResult.setText(data.getMain().getTemp());
        } else if (mode == WeatherDownloader.Mode.ZIPCODE) {
            zipCodeProgress.setVisibility(View.GONE);
            zipCodeResult.setText(String.format("%.2f", WeatherUnits.convertToFahrenheit(data.getMain().getTemp())));
        }
    }

