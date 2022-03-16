    private void handleOk() {
        Log.i("TGL", "handleOk");
        final Context context = WeatherWidgetThreeDayForecastConfigureActivity.this;

        if (selectedCity == null) {
            generator.getCityFromText(true);
            if (selectedCity == null) {
                return;
            }
        }

        addLocationForNewCity(selectedCity);

        // When the button is clicked, store the string locally
        saveTitlePref(context, mAppWidgetId, selectedCity.getCityId());

        // It is the responsibility of the configuration activity to update the app widget
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        WeatherWidgetThreeDayForecast.updateAppWidget(context, appWidgetManager, mAppWidgetId);

        // Make sure we pass back the original appWidgetId
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();
    }

