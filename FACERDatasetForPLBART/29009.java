    @Override
    protected void onStart() {
        super.onStart();
        if (!cityCountryName.equals("")) {
            requestWeather();
            //mFetchThreadData.queueResponce(0, cityCountryName);
        }
    }

