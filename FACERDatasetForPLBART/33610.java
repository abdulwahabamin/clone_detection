    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_weather_forecast, container, false);
        getCommonViews(view);
        TextView nightMorningEveningTitleTextView = (TextView) view.findViewById(
                R.id.night_morning_evening_title);
        nightMorningEveningTitleTextView.setText(getNightMorningEveningTitle());
        extraTemperaturesTextView = (TextView) view.findViewById(
                R.id.night_morning_evening_temperatures_text_view);
        return view;
    }

