    private void finish(IBinder binder) throws Exception {
        Class activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
        Method getDefaultMethod = activityManagerNativeClass.getDeclaredMethod("getDefault");
        Object activityManager = getDefaultMethod.invoke(null);
        Method finishActivityMethod = activityManager.getClass().getDeclaredMethod("finishActivity", IBinder.class, int.class, Intent.class);
        finishActivityMethod.invoke(activityManager, binder, Activity.RESULT_CANCELED, null);

    }

