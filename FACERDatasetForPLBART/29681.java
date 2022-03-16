  private void initVariables() {
    activity = getActivity();
    prefser = new Prefser(activity);
    BoxStore boxStore = MyApplication.getBoxStore();
    multipleDaysWeatherBox = boxStore.boxFor(MultipleDaysWeather.class);
  }

