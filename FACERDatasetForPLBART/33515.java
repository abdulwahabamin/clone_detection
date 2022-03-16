    /**
     * @param activity an activity from which this task is started
     */
    GetAvailableCitiesTask(FragmentActivity activity) {
        this.activity = activity;
        setContext(activity);
    }

