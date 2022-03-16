    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        unbindCurrentWeatherService(context);
        unbindLocationUpdateService(context);
    }

