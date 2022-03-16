        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key) {
                case Constants.KEY_PREF_WIDGET_THEME:
                    Intent intent = new Intent(Constants.ACTION_APPWIDGET_THEME_CHANGED);
                    intent.setPackage("org.thosp.yourlocalweather");
                    getActivity().sendBroadcast(intent);
                    setSummary(Constants.KEY_PREF_WIDGET_THEME);
                    break;
                case Constants.KEY_PREF_LOCATION_GPS_ENABLED:
                    break;
                case Constants.KEY_PREF_WIDGET_SHOW_LABELS:
                    intent = new Intent(Constants.ACTION_APPWIDGET_THEME_CHANGED);
                    intent.setPackage("org.thosp.yourlocalweather");
                    getActivity().sendBroadcast(intent);
                    break;
                case Constants.KEY_PREF_WIDGET_GRAPH_NATIVE_SCALE:
                    GraphUtils.invalidateGraph();
                    intent = new Intent(Constants.ACTION_APPWIDGET_CHANGE_GRAPH_SCALE);
                    intent.setPackage("org.thosp.yourlocalweather");
                    getActivity().sendBroadcast(intent);
                    break;
                case Constants.KEY_PREF_WIDGET_SHOW_CONTROLS:
                    intent = new Intent(Constants.ACTION_APPWIDGET_SETTINGS_SHOW_CONTROLS);
                    intent.setPackage("org.thosp.yourlocalweather");
                    getActivity().sendBroadcast(intent);
                case Constants.KEY_PREF_UPDATE_DETAIL:
                    intent = new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE);
                    intent.setPackage("org.thosp.yourlocalweather");
                    getActivity().sendBroadcast(intent);
                    setDetailedSummary(Constants.KEY_PREF_UPDATE_DETAIL);
                    break;
            }
        }

