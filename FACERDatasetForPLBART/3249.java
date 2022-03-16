    public static void tryRefreshCurrentFragment() {
        if (useActivity != null) {
            refreshCurrentFragment(useActivity);
        } else {
           // BLog.e("TRY","********************** activity=null");
        }
    }

