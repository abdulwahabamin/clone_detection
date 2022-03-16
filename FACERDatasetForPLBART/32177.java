    private void initializeWeatherReceiver() {
        mWeatherUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.hasExtra("addresses")) {
                    address = (Address) intent.getExtras().getParcelable("addresses");
                    resolvedLocationAddress.setText(Utils.getCityAndCountryFromAddress(address));
                } else {
                    resolvedLocationAddress.setText(context.getString(R.string.location_not_found));
                }
                addLocatonButton.setVisibility(View.VISIBLE);
            }
        };
    }

