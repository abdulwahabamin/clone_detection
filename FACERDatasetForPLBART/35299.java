    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        // 在第一个 widget 被创建时，开�?��?务
        context.startService(new Intent(context,WeatherWidgetService.class));
    }

