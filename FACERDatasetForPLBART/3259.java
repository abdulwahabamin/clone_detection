    public static void removeFragmentFromFragmentManager(Activity activity, String TAG_FRAGMENT) {
        if (activity != null) {
            Fragment fragment = activity.getFragmentManager().findFragmentByTag(TAG_FRAGMENT);
            if(fragment != null)
                activity.getFragmentManager().beginTransaction().remove(fragment).commit();


        }
    }

