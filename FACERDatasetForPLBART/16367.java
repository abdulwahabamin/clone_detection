    /**
     * 添加指定Activity到堆栈
     *
     * @param activity Activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

