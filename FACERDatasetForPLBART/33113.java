    private void createWidgetActionSettingsDialog(final int widgetId, final ArrayList<String> widgetActionPlaces) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.widget_setting_actions, null);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(this);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.widget_actions, android.R.layout.simple_spinner_item);

        Spinner cityActions = forecastSettingView.findViewById(R.id.widget_setting_actions_city);
        TextView cityActionLabel = forecastSettingView.findViewById(R.id.widget_setting_actions_city_label);
        final WidgetActionListener cityActionsListener;
        if (widgetActionPlaces.contains("action_city")) {
            cityActions.setVisibility(View.VISIBLE);
            cityActionLabel.setVisibility(View.VISIBLE);
            WidgetActions cityAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_city"), "action_city");
            cityActions.setAdapter(adapter);
            cityActions.setSelection(cityAction.getComboSelection());
            cityActionsListener = new WidgetActionListener(cityAction);
            cityActions.setOnItemSelectedListener(cityActionsListener);
        } else {
            cityActions.setVisibility(View.GONE);
            cityActionLabel.setVisibility(View.GONE);
            cityActionsListener = null;
        }

        Spinner mainIconActions = forecastSettingView.findViewById(R.id.widget_setting_actions_main_icon);
        TextView mainIconActionsLabel = forecastSettingView.findViewById(R.id.widget_setting_actions_main_icon_label);
        final WidgetActionListener mainIconActionsListener;
        if (widgetActionPlaces.contains("action_current_weather_icon")) {
            mainIconActions.setVisibility(View.VISIBLE);
            mainIconActionsLabel.setVisibility(View.VISIBLE);
            WidgetActions mainIconAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_current_weather_icon"), "action_current_weather_icon");
            mainIconActions.setAdapter(adapter);
            mainIconActions.setSelection(mainIconAction.getComboSelection());
            mainIconActionsListener = new WidgetActionListener(mainIconAction);
            mainIconActions.setOnItemSelectedListener(mainIconActionsListener);
        } else {
            mainIconActions.setVisibility(View.GONE);
            mainIconActionsLabel.setVisibility(View.GONE);
            mainIconActionsListener = null;
        }

        Spinner forecastActions = forecastSettingView.findViewById(R.id.widget_setting_actions_forecast);
        TextView forecastActionsLabel = forecastSettingView.findViewById(R.id.widget_setting_actions_forecast_label);
        final WidgetActionListener forecastActionsListener;
        if (widgetActionPlaces.contains("action_forecast")) {
            forecastActions.setVisibility(View.VISIBLE);
            forecastActionsLabel.setVisibility(View.VISIBLE);
            WidgetActions forecastAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_forecast"), "action_forecast");
            forecastActions.setAdapter(adapter);
            forecastActions.setSelection(forecastAction.getComboSelection());
            forecastActionsListener = new WidgetActionListener(forecastAction);
            forecastActions.setOnItemSelectedListener(forecastActionsListener);
        } else {
            forecastActions.setVisibility(View.GONE);
            forecastActionsLabel.setVisibility(View.GONE);
            forecastActionsListener = null;
        }

        Spinner graphActions = forecastSettingView.findViewById(R.id.widget_setting_actions_graph);
        TextView graphActionsLabel = forecastSettingView.findViewById(R.id.widget_setting_actions_graph_label);
        final WidgetActionListener graphActionsListener;
        if (widgetActionPlaces.contains("action_graph")) {
            graphActions.setVisibility(View.VISIBLE);
            graphActionsLabel.setVisibility(View.VISIBLE);
            WidgetActions graphAction = WidgetActions.getById(widgetSettingsDbHelper.getParamLong(widgetId, "action_graph"), "action_graph");
            graphActions.setAdapter(adapter);
            graphActions.setSelection(graphAction.getComboSelection());
            graphActionsListener = new WidgetActionListener(graphAction);
            graphActions.setOnItemSelectedListener(graphActionsListener);
        } else {
            graphActions.setVisibility(View.GONE);
            graphActionsLabel.setVisibility(View.GONE);
            graphActionsListener = null;
        }

        builder.setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (cityActionsListener != null) {
                            widgetSettingsDbHelper.saveParamLong(
                                    widgetId,
                                    "action_city",
                                    cityActionsListener.getWidgetAction().getId());
                        }
                        if (mainIconActionsListener != null) {
                            widgetSettingsDbHelper.saveParamLong(
                                    widgetId,
                                    "action_current_weather_icon",
                                    mainIconActionsListener.getWidgetAction().getId());
                        }
                        if (forecastActionsListener != null) {
                            widgetSettingsDbHelper.saveParamLong(
                                    widgetId,
                                    "action_forecast",
                                    forecastActionsListener.getWidgetAction().getId());
                        }
                        if (graphActionsListener != null) {
                            widgetSettingsDbHelper.saveParamLong(
                                    widgetId,
                                    "action_graph",
                                    graphActionsListener.getWidgetAction().getId());
                        }
                        Intent intent = new Intent(Constants.ACTION_APPWIDGET_CHANGE_SETTINGS);
                        intent.setPackage("org.thosp.yourlocalweather");
                        intent.putExtra("widgetId", widgetId);
                        sendBroadcast(intent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

