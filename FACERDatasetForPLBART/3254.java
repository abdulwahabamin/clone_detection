    public static void refreshDataCurrentFragment(Activity activity) {
        if (activity != null) {

            BRefreshable f = getCurrentRefeshableFragment(activity);
            if (f != null) {
                f.refreshData();
            }

        }
    }

