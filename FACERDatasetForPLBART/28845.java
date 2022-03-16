    public CharSequence getPageTitleForActionBar(int position) {
        long time = lastUpdateTime;
        int currentCityId = cities.get(position).getCityId();
        for(CurrentWeatherData weatherData : currentWeathers) {
            if(weatherData.getCity_id() == currentCityId) {
                time = weatherData.getTimestamp();
                break;
            }
        }
        return String.format("%s (%s)", getPageTitle(position), StringFormatUtils.formatTime(mContext, lastUpdateTime*1000));
    }

