    public static void refreshDataCurrentIfFragment(Activity activity,Class ifRefreshableClass) {
        if (activity != null) {

            BRefreshable f = getCurrentRefeshableFragment(activity);
            if (f != null && f.getClass().getName().equals(ifRefreshableClass.getName())) {
                f.refreshData();
            }

        }
    }

