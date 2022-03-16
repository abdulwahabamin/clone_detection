    public CitiesRecyclerViewAdapter(Context context, List<CityWithWeather> cities) {
        mCities = cities;
        this.context = context;
        PreferencesHelper pref =  PreferencesHelper.getInstance();
        isMetric = context.getString(R.string.pref_unit_default_value)
                .equals(pref.getUnits(context));
    }

