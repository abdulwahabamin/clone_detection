    @Override
    public void onClick(View view) {
        new ForecastBottomSheetDialogFragment()
                .newInstance(mWeatherForecast)
                .show(mFragmentManager, "forecastBottomSheet");
    }

