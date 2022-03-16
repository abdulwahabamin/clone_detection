    private void bindServices() {
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), WidgetRefreshIconService.class),
                widgetRefreshIconConnection,
                Context.BIND_AUTO_CREATE);
    }

