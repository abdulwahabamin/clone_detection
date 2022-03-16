    @Override
    public WeatherCityFragment getItem(int position) {
        Bundle args = new Bundle();
        args.putInt("city_id", cities.get(position).getCityId());
        args.putIntArray("dataSetTypes", mDataSetTypes);

        return (WeatherCityFragment) Fragment.instantiate(mContext, WeatherCityFragment.class.getName(), args);
    }

