    /**
     * 结�?�全部的Activity
     * <p>
     * 将Activity 的所有Activity 进行finish();
     */
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (null != activity) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

