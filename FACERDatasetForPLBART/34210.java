    public ForecastBottomSheetDialogFragment newInstance(WeatherForecast weather) {
        ForecastBottomSheetDialogFragment fragment = new ForecastBottomSheetDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable("weatherForecast", weather);
        fragment.setArguments(args);
        return fragment;
    }

