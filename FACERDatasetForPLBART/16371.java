    /**
     * 结�?�指定Class的Activity
     *
     * @param cls 例如：MainActivity.class
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity != null && activity.getClass().equals(cls)) {
                finishActivity(activity);
                return;
            }
        }
    }

