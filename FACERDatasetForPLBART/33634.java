        @Override
        public int getCount() {
            return isRequestedThreeHourlyForecastInListForm() ?
                    jsonStringListsForChildListFragments.size() :
                    jsonStringsForChildFragments.size();
        }

