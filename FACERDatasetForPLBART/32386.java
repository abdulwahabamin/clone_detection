    @Override
    protected void finalize() throws Throwable {
        if (locationUpdateService != null) {
            unbindLocationUpdateService();
        }
        super.finalize();
    }

