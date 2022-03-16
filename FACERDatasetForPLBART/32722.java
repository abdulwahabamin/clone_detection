    public static void setCombinedGraphValues(Context context, Set<Integer> visibleGraphs) {
        Set<String> columnsToStore = new HashSet<>();
        for (Integer visibleColumn: visibleGraphs) {
            columnsToStore.add(String.valueOf(visibleColumn));
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet(
                Constants.KEY_PREF_COMBINED_GRAPH_VALUES, columnsToStore).apply();
    }

