    private void bindWidgetRefreshIconService() {
        getBaseContext().getApplicationContext().bindService(
                new Intent(getBaseContext().getApplicationContext(), WidgetRefreshIconService.class),
                widgetRefreshIconConnection,
                Context.BIND_AUTO_CREATE);
    }

