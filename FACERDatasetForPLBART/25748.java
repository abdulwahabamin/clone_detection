    public static void stopPolling(Context context) {
        Scheduler scheduler;
        if (Version.buildVersion() > Build.VERSION_CODES.LOLLIPOP) {
            scheduler = new JobWork();
            scheduler.stopPolling(context, JobSchedulerService.class, JobSchedulerService.class.getSimpleName());
        } else {
            scheduler = new AlarmWork();
            scheduler.stopPolling(context, AlarmService.class, AlarmService.class.getSimpleName());
        }
    }

