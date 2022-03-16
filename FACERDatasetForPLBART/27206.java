    public static DayWeatherFragment getInstance(int cityId, long time) {
        Bundle args = new Bundle();
        args.putInt(CITY_ID, cityId);
        args.putLong(DATE, time);
        DayWeatherFragment dayWeatherFragment = new DayWeatherFragment();
        dayWeatherFragment.setArguments(args);
        return dayWeatherFragment;
    }

