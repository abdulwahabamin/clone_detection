    private void setSnowBarChart(long locationId, Locale locale) {
        if (!visibleGraphs.contains(6)) {
            snowBarCard.setVisibility(View.GONE);
            return;
        } else {
            snowBarCard.setVisibility(View.VISIBLE);
        }
        Description graphDescription = new Description();
        graphDescription.setText("");
        snowBarChart.setDescription(graphDescription);
        snowBarChart.setDrawGridBackground(false);
        snowBarChart.setTouchEnabled(true);
        snowBarChart.setDragEnabled(true);
        snowBarChart.setMaxHighlightDistance(300);
        snowBarChart.setPinchZoom(true);
        snowBarChart.getLegend().setEnabled(false);
        snowBarChart.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        snowBarChart.setGridBackgroundColor(PreferenceUtil.getTextColor(this));

        GraphUtils.setupXAxis(
                snowBarChart.getXAxis(),
                weatherForecastList.get(locationId),
                PreferenceUtil.getTextColor(this),
                null,
                PreferenceUtil.getGraphGridColor(this),
                locale);

        YAxis yLeft = snowBarChart.getAxisLeft();
        yLeft.setEnabled(true);
        yLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yLeft.setDrawAxisLine(false);
        yLeft.setDrawGridLines(true);
        yLeft.enableGridDashedLine(5f, 10f, 0f);
        yLeft.setTextColor(PreferenceUtil.getTextColor(this));
        yLeft.setGridColor(PreferenceUtil.getGraphGridColor(this).getMainGridColor());
        yLeft.setXOffset(15);
        yLeft.setValueFormatter(rainSnowYAxisValueFormatter);

        snowBarChart.getAxisRight().setEnabled(false);

        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < weatherForecastList.get(locationId).size(); i++) {
            entries.add(new BarEntry(
                            i,
                            (float) AppPreference.getRainOrSnow(
                                    this,
                                    weatherForecastList.get(locationId).get(i).getSnow())
                    )
            );
        }

        BarDataSet set;
        if (snowBarChart.getData() != null) {
            snowBarChart.getData().removeDataSet(snowBarChart.getData().getDataSetByIndex(
                    snowBarChart.getData().getDataSetCount() - 1));
            set = new BarDataSet(entries, getString(R.string.graph_snow_label));
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#009688"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            BarData data = new BarData(set);
            snowBarChart.setData(data);
        } else {
            set = new BarDataSet(entries, getString(R.string.graph_snow_label));
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#009688"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            BarData data = new BarData(set);
            snowBarChart.setData(data);
        }
        snowBarChart.invalidate();
    }

