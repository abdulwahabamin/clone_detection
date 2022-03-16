    @Override
    public void onDestroy() {
        super.onDestroy();
        if (retrieveWeatherInformationJsonStringTask != null) {
            retrieveWeatherInformationJsonStringTask.cancel(true);
        }
    }

