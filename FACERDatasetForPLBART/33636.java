        @Override
        public Fragment getItem(int position) {
            return isRequestedThreeHourlyForecastInListForm() ?
                    WeatherThreeHourlyForecastChildListFragment.newInstance(
                            jsonStringListsForChildListFragments.get(position)) :
                    WeatherInfoFragment.newInstance(weatherInfoType, cityName,
                            jsonStringsForChildFragments.get(position));
        }

