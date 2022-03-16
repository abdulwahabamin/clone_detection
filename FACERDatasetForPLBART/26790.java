    @Override
    public Fragment getItem(int position) {
        int cityId = mDays.get(position).getHours().get(0).getCity_id().intValue();
        long time = mDays.get(position).getHours().get(0).getDt().getTime();
        return DayWeatherFragment.getInstance(cityId, time);
    }

