    /**
     * Initialize given widgets to default state, where we launch Music on
     * default click and hide actions if service not running.
     */
    private void defaultAppWidget(Context context, int[] appWidgetIds) {
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
    	String widget_type = sp.getString( WIDGET_STYLE, context.getResources().getString(R.string.widget_style_light) );

    	final RemoteViews views = new RemoteViews(context.getPackageName(),
                (widget_type.equals(context.getResources().getString(R.string.widget_style_light))?R.layout.fourbytwo_app_widget:R.layout.fourbytwo_app_widget_dark));
        

        linkButtons(context, views, false /* not playing */);
        pushUpdate(context, appWidgetIds, views);
    }

