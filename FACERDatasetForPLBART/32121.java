    public static WidgetSettingsDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new WidgetSettingsDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

