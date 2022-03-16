    private static void startPolling(Context context) {
        Scheduler scheduler;
        long seconds = ResourceProvider.getSchedule(PreferencesHelper.get(ResourceProvider.POLLING_TIME, 0));
        if (Version.buildVersion() > Build.VERSION_CODES.LOLLIPOP) {
            scheduler = new JobWork();
            scheduler.startPolling(context, seconds, JobSchedulerService.class, JobSchedulerService.class.getSimpleName());
        } else {
            scheduler = new AlarmWork();
            scheduler.startPolling(context, seconds, AlarmService.class, AlarmService.class.getSimpleName());
        }
    }

