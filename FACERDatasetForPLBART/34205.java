    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICK_CITY:
                ConnectionDetector connectionDetector = new ConnectionDetector(this);
                if (resultCode == RESULT_OK) {
                    mHeaderCity.setText(Utils.getCityAndCountry(this));

                    if (connectionDetector.isNetworkAvailableAndConnected()) {
                        startService(new Intent(this, CurrentWeatherService.class));
                    }
                }
                break;
        }
    }

