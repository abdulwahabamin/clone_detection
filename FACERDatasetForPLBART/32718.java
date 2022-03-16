    public static void setForecastActivityColumns(Context context, Set<Integer> visibleColumns) {
        Set<String> columnsToStore = new HashSet<>();
        for (Integer visibleColumn: visibleColumns) {
            columnsToStore.add(String.valueOf(visibleColumn));
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet(
                Constants.KEY_PREF_FORECAST_ACTIVITY_COLUMNS, columnsToStore).apply();
    }

