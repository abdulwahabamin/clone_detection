    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_modal , container, false);
        condition = rootView.findViewById(R.id.description);
        preferences = new Prefs(getContext());
        nightValue = rootView.findViewById(R.id.night_temperature);
        mornValue = rootView.findViewById(R.id.morning_temperature);
        dayValue = rootView.findViewById(R.id.day_temperature);
        eveValue = rootView.findViewById(R.id.evening_temperature);
        windIcon = rootView.findViewById(R.id.wind_icon);
        windIcon.setTypeface(weatherFont);
        windIcon.setText(getString(R.string.speed_icon));
        rainIcon = rootView.findViewById(R.id.rain_icon);
        rainIcon.setTypeface(weatherFont);
        rainIcon.setText(getString(R.string.rain));
        snowIcon = rootView.findViewById(R.id.snow_icon);
        snowIcon.setTypeface(weatherFont);
        snowIcon.setText(getString(R.string.snow));
        humidityIcon = rootView.findViewById(R.id.humidity_icon);
        humidityIcon.setTypeface(weatherFont);
        humidityIcon.setText(getString(R.string.humidity_icon));
        pressureIcon = rootView.findViewById(R.id.pressure_icon);
        pressureIcon.setTypeface(weatherFont);
        pressureIcon.setText(getString(R.string.pressure_icon));
        windText = rootView.findViewById(R.id.wind);
        rainText = rootView.findViewById(R.id.rain);
        snowText = rootView.findViewById(R.id.snow);
        humidityText = rootView.findViewById(R.id.humidity);
        pressureText = rootView.findViewById(R.id.pressure);
        updateElements();
        return rootView;
    }

