    public static void refreshDataCurrentIfFragment(Class ifRefreshableClass) {
        if (useActivity != null) {

            final BRefreshable f = getCurrentRefeshableFragment(useActivity);
            //BLog.e("REFC","current: "+f.getClass().getName()+" -- need match : "+ifRefreshableClass.getName());
            if (f != null && f.getClass().getName().equals(ifRefreshableClass.getName())) {
                useActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        f.refreshData();
                    }
                });
            }

        }
    }

