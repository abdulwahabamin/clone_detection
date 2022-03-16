        /**
         * Obtains the page title for the three hourly weather forecast.
         *
         * @param position position in a view pager for the requested title
         * @return a formatted time or date string
         */
        private CharSequence getPageTitleForThreeHourlyWeatherForecast(int position) {
            String template = isRequestedThreeHourlyForecastInListForm() ?
                    DAY_TEMPLATE : TIME_TEMPLATE;
            String jsonString = isRequestedThreeHourlyForecastInListForm() ?
                    jsonStringListsForChildListFragments.get(position).get(0) :
                    jsonStringsForChildFragments.get(position);

            long time = 1000 * new Gson().fromJson(jsonString,
                    CityThreeHourlyWeatherForecast.class).getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

            simpleDateFormat.applyLocalizedPattern(template);
            return simpleDateFormat.format(new Date(time));
        }

