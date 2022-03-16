    private void bindWakeUpService() {
        if (wakeUpService != null) {
            return;
        }
        appendLog(getBaseContext(), getClass().getName(), "bindWakeUpService ", wakeUpService);
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), AppWakeUpManager.class),
                wakeUpServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

