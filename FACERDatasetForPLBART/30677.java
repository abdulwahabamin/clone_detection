    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCityWeatherFavoriteComponent
                .builder()
                .openWeatherMapComponent(((WeatherApplication) getActivity().getApplication()).getOpenWeatherMapComponent())
                .build()
                .inject(this);
    }

