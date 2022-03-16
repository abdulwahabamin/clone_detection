    @Override
    public void startPolling(Context context, long seconds, Class<?> cls, String action) {

        stopPolling(context, cls, action);

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(context.getPackageName(), cls.getName()));
        builder.setPeriodic(seconds * 1000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        jobScheduler.schedule(builder.build());
    }

