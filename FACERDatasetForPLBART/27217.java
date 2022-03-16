    public static void scheduleJob(Context context) {
        int interval = Integer.parseInt(PreferencesHelper.getInstance().getSyncInterval(context));
        FirebaseJobDispatcher dispatcher =
                new FirebaseJobDispatcher(new GooglePlayDriver(context));
        Job job = dispatcher.newJobBuilder()
                .setLifetime(Lifetime.FOREVER)
                .setService(WeatherJobService.class)
                .setTag("UpdateWeatherJob")
                .setRecurring(true)
                //.setTrigger(Trigger.executionWindow(30, 60))
                .setTrigger(Trigger.executionWindow(interval, interval + 60)) // default once per hour
                .setReplaceCurrent(true)
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .build();
        int result = dispatcher.schedule(job);
        if (result != FirebaseJobDispatcher.SCHEDULE_RESULT_SUCCESS) {
            Log.e(LOG_TAG,"Error schedule request :" + result);
        }
    }

