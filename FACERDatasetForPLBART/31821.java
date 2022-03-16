    private void startAlarms() {
        appendLog(this, TAG, "scheduleStart at boot, SDK=", Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            JobScheduler jobScheduler = getSystemService(JobScheduler.class);
            boolean scheduled = false;
            for (JobInfo jobInfo: jobScheduler.getAllPendingJobs()) {
                if (jobInfo.getId() > 0) {
                    appendLog(this, TAG, "scheduleStart does not start - it's scheduled already");
                    scheduled = true;
                    break;
                }
            }
            if (!scheduled) {
                appendLog(this, TAG, "scheduleStart at MainActivity");
                AppPreference.setLastSensorServicesCheckTimeInMs(this, 0);
                jobScheduler.cancelAll();
                ComponentName serviceComponent = new ComponentName(this, StartAutoLocationJob.class);
                JobInfo.Builder builder = new JobInfo.Builder(StartAutoLocationJob.JOB_ID, serviceComponent);
                builder.setMinimumLatency(1 * 1000); // wait at least
                builder.setOverrideDeadline(3 * 1000); // maximum delay
                jobScheduler.schedule(builder.build());
            }
        } else {
            Intent intentToStartUpdate = new Intent("org.thosp.yourlocalweather.action.START_ALARM_SERVICE");
            intentToStartUpdate.setPackage("org.thosp.yourlocalweather");
            startService(intentToStartUpdate);
        }
    }

