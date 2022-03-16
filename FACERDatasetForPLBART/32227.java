    @Override
    public void unbindService(ServiceConnection conn) {
        try {
            super.unbindService(conn);
        } catch (Exception e) {
            appendLog(this, "TAG", e.getMessage(), e);
        }
    }

