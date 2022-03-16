    protected static int[] getWidgetSize(Context context, int appWidgetId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(
                context.getApplicationContext());

        AppWidgetProviderInfo providerInfo = appWidgetManager.getAppWidgetInfo(appWidgetId);

        int mWidgetLandWidth = providerInfo.minWidth;
        int mWidgetPortHeight = providerInfo.minHeight;
        int mWidgetPortWidth = providerInfo.minWidth;
        int mWidgetLandHeight = providerInfo.minHeight;

        Bundle mAppWidgetOptions = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mAppWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId);
        }

        if (mAppWidgetOptions != null
                && mAppWidgetOptions
                .getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH) > 0) {

            mWidgetPortWidth = mAppWidgetOptions
                    .getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
            mWidgetLandWidth = mAppWidgetOptions
                    .getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH);
            mWidgetLandHeight = mAppWidgetOptions
                    .getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
            mWidgetPortHeight = mAppWidgetOptions
                    .getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT);
        } else {
            mWidgetLandWidth = providerInfo.minWidth;
            mWidgetPortHeight = providerInfo.minHeight;
            mWidgetPortWidth = providerInfo.minWidth;
            mWidgetLandHeight = providerInfo.minHeight;
        }

        int mWidgetWidthPerOrientation = mWidgetPortWidth;
        int mWidgetHeightPerOrientation = mWidgetPortHeight;
        if (!isPortrait(context)) {
            mWidgetWidthPerOrientation = mWidgetLandWidth;
            mWidgetHeightPerOrientation = mWidgetLandHeight;
        }
        int[] size = new int[2];
        if (AppPreference.isWidgetGraphNativeScaled(context)) {
            size[0] = mWidgetWidthPerOrientation;
            size[1] = mWidgetHeightPerOrientation;
            return size;
        }
        size[0] = dipToPixels(context, mWidgetWidthPerOrientation);
        size[1] = dipToPixels(context, mWidgetHeightPerOrientation);
        return size;
    }

