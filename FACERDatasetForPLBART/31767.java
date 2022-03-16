    private void setRainBarChart(long locationId, Locale locale) {
        if (!visibleGraphs.contains(4)) {
            rainBarCard.setVisibility(View.GONE);
            return;
        } else {
            rainBarCard.setVisibility(View.VISIBLE);
        }
        Description graphDescription = new Description();
        graphDescription.setText("");
        rainBarChart.setDescription(graphDescription);
        rainBarChart.setDrawGridBackground(false);
        rainBarChart.setTouchEnabled(true);
        rainBarChart.setDragEnabled(true);
        rainBarChart.setMaxHighlightDistance(300);
        rainBarChart.setPinchZoom(true);
        rainBarChart.getLegend().setEnabled(false);
        rainBarChart.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        rainBarChart.setGridBackgroundColor(PreferenceUtil.getTextColor(this));

        GraphUtils.setupXAxis(
                rainBarChart.getXAxis(),
                weatherForecastList.get(locationId),
                PreferenceUtil.getTextColor(this),
                null,
                PreferenceUtil.getGraphGridColor(this),
                locale);

        YAxis yLeft = rainBarChart.getAxisLeft();
        yLeft.setEnabled(true);
        yLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yLeft.setDrawAxisLine(false);
        yLeft.setDrawGridLines(true);
        yLeft.enableGridDashedLine(5f, 10f, 0f);
        yLeft.setTextColor(PreferenceUtil.getTextColor(this));
        yLeft.setGridColor(PreferenceUtil.getGraphGridColor(this).getMainGridColor());
        yLeft.setXOffset(15);
        yLeft.setValueFormatter(rainSnowYAxisValueFormatter);

        rainBarChart.getAxisRight().setEnabled(false);

        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < weatherForecastList.get(locationId).size(); i++) {
            entries.add(new BarEntry(
                            i,
                            (float) AppPreference.getRainOrSnow(
                                    this,
                                    weatherForecastList.get(locationId).get(i).getRain())
                    )
            );
        }

        BarDataSet set;
        if (rainBarChart.getData() != null) {
            rainBarChart.getData().removeDataSet(rainBarChart.getData().getDataSetByIndex(
                    rainBarChart.getData().getDataSetCount() - 1));
            set = new BarDataSet(entries, getString(R.string.graph_rain_label));
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#5677FC"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            BarData data = new BarData(set);
            rainBarChart.setData(data);
        } else {
            set = new BarDataSet(entries, getString(R.string.graph_rain_label));
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#5677FC"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            BarData data = new BarData(set);
            rainBarChart.setData(data);
        }
        rainBarChart.invalidate();
    }

