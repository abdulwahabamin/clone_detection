        /**
         * Obtains the page title for the single day weather forecast.
         *
         * @param position position in a view pager for the requested title
         * @return a formatted date string
         */
        private CharSequence getPageTitleForDailyWeatherForecast(int position) {
            long time = 1000 * new Gson().fromJson(jsonStringsForChildFragments.get(position),
                    CityDailyWeatherForecast.class).getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyLocalizedPattern(DAY_TEMPLATE);
            return simpleDateFormat.format(new Date(time));
        }

