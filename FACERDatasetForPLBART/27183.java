    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = PreferencesHelper.getInstance();
        localDataSource = ((WeatherApp) getActivity().getApplicationContext()).getLocalDataSource();
        if (savedInstanceState != null) {
            cityId = getArguments().getLong(ARG_ITEM_ID);
            openCity((int) cityId);
            localDataSource.getForecast((int) cityId);
        }
    }

