    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weatherInfoType = getArguments().getParcelable(WEATHER_INFORMATION_TYPE);
        jsonStringsForChildFragments = new ArrayList<>();
        extractJsonDataForChildFragments();
    }

