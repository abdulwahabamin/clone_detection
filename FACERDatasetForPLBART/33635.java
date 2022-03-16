        /**
         * Determines whether the requested forecast is a three-hourly forecast that should be
         * displayed as several daily lists.
         */
        private boolean isRequestedThreeHourlyForecastInListForm() {
            return jsonStringListsForChildListFragments != null;
        }

