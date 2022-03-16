    private void setCombinedChart(long locationId, Locale locale) {
        if (!visibleGraphs.contains(0)) {
            combinedChartCard.setVisibility(View.GONE);
            return;
        } else {
            combinedChartCard.setVisibility(View.VISIBLE);
        }
        GraphUtils.generateCombinedGraph(this,
                                        combinedChart,
                                        AppPreference.getCombinedGraphValues(this),
                                        weatherForecastList.get(locationId),
                                        locationId,
                                        locale,
                                        null,
                                        8,
                                        2,
                                        PreferenceUtil.getTextColor(this),
                                        PreferenceUtil.getBackgroundColor(this),
                                        PreferenceUtil.getGraphGridColor(this),
                            true
        );
    }

