    /**
     * 结�?�指定的Activity
     *
     * @param activity who extends Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

