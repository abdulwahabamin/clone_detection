    public static void setGraphsActivityVisibleGraphs(Context context, Set<Integer> visibleGraphs) {
        Set<String> columnsToStore = new HashSet<>();
        for (Integer visibleColumn: visibleGraphs) {
            columnsToStore.add(String.valueOf(visibleColumn));
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet(
                Constants.KEY_PREF_GRAPHS_ACTIVITY_VISIBLE_GRAPHS, columnsToStore).apply();
    }

