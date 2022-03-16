    /**
     * 结�?�Activity
     * <p>
     * 栈中最上�?�那个  弹出栈
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        if (activity != null) {
            finishActivity(activity);
        }
    }

