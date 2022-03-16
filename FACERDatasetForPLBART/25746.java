    public static void startService(Context context, boolean allowPoll) {

        Class cls = Version.buildVersion() > Build.VERSION_CODES.LOLLIPOP ? JobSchedulerService.class : AlarmService.class;
        context.startService(new Intent(context, cls));
        if (!allowPoll) {
            return;
        }
        startPolling(context);
    }

