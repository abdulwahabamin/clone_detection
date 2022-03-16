    @Override
    public void updateWeeksView(List<WeekWeather> weathers, String[] weeks,List<Integer> lists) {
        weekWeatherView.setData(weathers,weeks,lists);
        Debug.startMethodTracing();
        weekWeatherView.notifyDateChanged();
    }

