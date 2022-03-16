    private void openWidgetSettings(Context context, int widgetId, String settingsName) {
        Intent popUpIntent = new Intent(context, WidgetSettingsDialogue.class);
        popUpIntent.putExtra("widgetId", widgetId);
        popUpIntent.putExtra("settings_option", settingsName);
        popUpIntent.putStringArrayListExtra("widget_action_places", getEnabledActionPlaces());
        popUpIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(popUpIntent);
    }

