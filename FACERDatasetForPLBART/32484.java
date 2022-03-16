    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationUpdateService != null) {
            unbindLocationUpdateService();
        }
        if (widgetRefreshIconService != null) {
            unbindWidgetRefreshIconService();
        }
    }

