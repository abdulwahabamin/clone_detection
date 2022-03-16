    protected void updateWeatherForecastFromNetwork(String updateSource, Context context) {
        if (currentLocation == null) {
            return;
        }
        boolean isNetworkAvailable = connectionDetector.isNetworkAvailableAndConnected();
        if (isNetworkAvailable) {
            setVisibleUpdating(true);
            sendMessageToWeatherForecastService(currentLocation.getId(), updateSource);
        } else {
            Toast.makeText(this,
                    R.string.connection_not_found,
                    Toast.LENGTH_SHORT).show();
        }
    }

