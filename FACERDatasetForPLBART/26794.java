    public HoursRecyclerViewAdapter(Context context, List<OrmWeather> hours) {
        mHours = hours;
        this.context= context;
        PreferencesHelper pref =  PreferencesHelper.getInstance();
        isMetric = context.getString(R.string.pref_unit_default_value)
                .equals(pref.getUnits(context));
    }

