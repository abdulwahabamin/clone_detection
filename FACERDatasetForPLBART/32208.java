    private void bindWakeUpService() {
        appendLog(getBaseContext(), getClass().getSimpleName(), "bind wakeup service:", this.toString());
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), AppWakeUpManager.class),
                wakeUpServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

