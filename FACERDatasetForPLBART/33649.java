    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherInformationDisplayer = new WeatherInformationDisplayer(getContext(),
                iconCacheRequestListener.getIconMemoryCache());
    }

