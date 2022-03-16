    @Override
    public boolean onUnbind(Intent intent) {
        unbindServices();
        appendLog(getBaseContext(), TAG, "onUnbind all services");
        return false;
    }

