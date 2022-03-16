    public static void startPostponedTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.startPostponedEnterTransition();
        } else {
            ActivityCompat.startPostponedEnterTransition(activity);
        }
    }

