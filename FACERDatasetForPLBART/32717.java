    public static Set<Integer> getForecastActivityColumns(Context context) {
        Set<String> defaultVisibleColumns = new HashSet<>();
        defaultVisibleColumns.add("1");
        defaultVisibleColumns.add("2");
        defaultVisibleColumns.add("3");
        defaultVisibleColumns.add("5");
        Set<String> visibleColumns = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
                Constants.KEY_PREF_FORECAST_ACTIVITY_COLUMNS, defaultVisibleColumns);
        Set<Integer> result = new HashSet<>();
        for (String visibleColumn: visibleColumns) {
            result.add(Integer.valueOf(visibleColumn));
        }
        return result;
    }

