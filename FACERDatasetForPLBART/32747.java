    public static Bitmap getCombinedChart(Context context,
                                          int widgetId,
                                          Float heightMultiplier,
                                          List<DetailedWeatherForecast> weatherForecastList,
                                          long locationId,
                                          Locale locale) {

        if (combinedGraphs.get(widgetId) != null) {
            return combinedGraphs.get(widgetId);
        }

        WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(context);
        Boolean showLegend = widgetSettingsDbHelper.getParamBoolean(widgetId, "combinedGraphShowLegend");

        if (showLegend == null) {
            showLegend = true;
        }

        int[] size = getWidgetSize(context, widgetId);
        int width = size[0];
        int height;
        if (heightMultiplier == null) {
            height = size[1];
        } else {
            height = (int) (width * heightMultiplier);
        }

        int yAxisValues = 4;
        if (height > 800) {
            yAxisValues += 6;
        } else if (height > 700) {
            yAxisValues += 4;
        } else if (height > 500) {
            yAxisValues += 2;
        }

        CombinedChart combinedChart = generateCombinedGraph(context,
                                    null,
                                                            getCombinedGraphValuesFromSettings(context, widgetSettingsDbHelper, widgetId),
                                                            weatherForecastList,
                                                            locationId,
                                                            locale,
                                                            18f,
                                                            yAxisValues,
                                                            0,
                                                            AppPreference.getTextColor(context),
                                                            AppPreference.getWidgetBackgroundColor(context),
                                                            AppPreference.getWidgetGraphGridColor(context),
                                                            showLegend);

        combinedChart.setBackgroundColor(ContextCompat.getColor(context,
                R.color.widget_transparentTheme_colorBackground));

        int bitmapHeight = height;

        if (!showLegend) {
            bitmapHeight += 20;
        }

        Bitmap.Config bitmapConfig = Bitmap.Config.ARGB_8888;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            bitmapConfig = Bitmap.Config.RGBA_F16;
        }
        Bitmap combinedChartBitmap = Bitmap.createBitmap(width, bitmapHeight, bitmapConfig);
        Canvas combinedChartCanvas = new Canvas(combinedChartBitmap);
        combinedChart.layout(0, 0, width, height);
        combinedChart.draw(combinedChartCanvas);
        combinedGraphs.put(widgetId, combinedChartBitmap);
        return combinedChartBitmap;
    }

