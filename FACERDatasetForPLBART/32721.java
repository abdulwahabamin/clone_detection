    public static Set<Integer> getCombinedGraphValues(Context context) {
        Set<String> defaultVisibleGraphs = new HashSet<>();
        defaultVisibleGraphs.add("0");
        defaultVisibleGraphs.add("1");
        defaultVisibleGraphs.add("2");
        Set<String> visibleColumns = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
                Constants.KEY_PREF_COMBINED_GRAPH_VALUES, defaultVisibleGraphs);
        Set<Integer> result = new HashSet<>();
        for (String visibleColumn: visibleColumns) {
            result.add(Integer.valueOf(visibleColumn));
        }
        return result;
    }

