    private void unbindWidgetRefreshIconService() {
        if (widgetRefreshIconService == null) {
            return;
        }
        getBaseContext().getApplicationContext().unbindService(widgetRefreshIconConnection);
    }

