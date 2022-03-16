    private void unbindScreenOnOffService() {
        if (screenOnOffUpdateService == null) {
            return;
        }
        context.getApplicationContext().unbindService(screenOnOffUpdateServiceConnection);
    }

