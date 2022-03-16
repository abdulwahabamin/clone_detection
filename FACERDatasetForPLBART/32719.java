    public static Set<Integer> getGraphsActivityVisibleGraphs(Context context) {
        Set<String> defaultVisibleGraphs = new HashSet<>();
        defaultVisibleGraphs.add("0");
        defaultVisibleGraphs.add("1");
        defaultVisibleGraphs.add("2");;
        defaultVisibleGraphs.add("4");
        defaultVisibleGraphs.add("6");
        defaultVisibleGraphs.add("7");
        Set<String> visibleColumns = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
                Constants.KEY_PREF_GRAPHS_ACTIVITY_VISIBLE_GRAPHS, defaultVisibleGraphs);
        Set<Integer> result = new HashSet<>();
        for (String visibleColumn: visibleColumns) {
            result.add(Integer.valueOf(visibleColumn));
        }
        return result;
    }

