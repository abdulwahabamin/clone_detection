    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));

        String settingOption = getIntent().getStringExtra("settings_option");
        ArrayList<String> widgetActionPlaces = getIntent().getStringArrayListExtra("widget_action_places");

        switch (settingOption) {
            case "detailsSetting": createDetailsSettingsDialog(getIntent().getIntExtra("widgetId", 0)); break;
            case "graphSetting": createGraphSettingDialog(getIntent().getIntExtra("widgetId", 0)); break;
            case "forecastSettings": createForecastSettingsDialog(getIntent().getIntExtra("widgetId", 0)); break;
            case "locationSettings": createLocationSettingsDialog(getIntent().getIntExtra("widgetId", 0)); break;
            case "widgetActionSettings": createWidgetActionSettingsDialog(
                    getIntent().getIntExtra("widgetId", 0),
                    widgetActionPlaces); break;
        }
    }

