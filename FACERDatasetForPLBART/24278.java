    /**
     * Initialize given widgets to default state, where we launch Music on default click
     * and hide actions if service not running.
     */
    private void defaultAppWidget(Context context, int[] appWidgetIds) {
        final Resources res = context.getResources();
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.appwidget);
        
        views.setTextViewText(R.id.title, res.getText(R.string.widget_initial_text));
        views.setTextViewText(R.id.artist, "");
        views.setTextViewText(R.id.genre, "");

        linkButtons(context, views, false /* not playing */);
        pushUpdate(context, appWidgetIds, views);
    }

