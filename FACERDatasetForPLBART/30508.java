    public static WeatherFragment newInstance(String cityId) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(PARAM, cityId);
        fragment.setArguments(args);
        return fragment;
    }

