    private void sendUpdateToLocationBackends() {
        appendLog(getBaseContext(), TAG,
                "update():nextScanningAllowedFrom:",
                nextScanningAllowedFrom);
        if(nextScanningAllowedFrom == null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                scanning = wifiManager.startScan();
            } else {
                scanning = true;
            }
            if (scanning) {
                nextScanningAllowedFrom = Calendar.getInstance();
                nextScanningAllowedFrom.add(Calendar.MINUTE, 15);
            }
        }
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            ComponentName serviceComponent = new ComponentName(this, NetworkLocationCellsOnlyJob.class);
            JobInfo.Builder builder = new JobInfo.Builder(NetworkLocationCellsOnlyJob.JOB_ID, serviceComponent);
            builder.setMinimumLatency(8000); // wait at least
            builder.setOverrideDeadline(10000); // maximum delay
            JobInfo jobInfo = builder.build();
            jobId= jobInfo.getId();
            JobScheduler jobScheduler = getSystemService(JobScheduler.class);
            jobScheduler.schedule(jobInfo);
        } else {
            intentToCancel = getIntentToGetCellsOnly();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime() + 8000,
                        intentToCancel);
            } else {
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime() + 8000,
                        intentToCancel);
            }
        }
        appendLog(getBaseContext(), TAG, "update():cells only task scheduled");
    }

