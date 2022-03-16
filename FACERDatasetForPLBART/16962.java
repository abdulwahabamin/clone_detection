    public static void postponeTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.postponeEnterTransition();
        } else {
            ActivityCompat.postponeEnterTransition(activity);
        }
    }

