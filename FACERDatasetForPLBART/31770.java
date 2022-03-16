    private void setPressureChart(long locationId, Locale locale) {
        if (!visibleGraphs.contains(7)) {
            pressureChartCard.setVisibility(View.GONE);
            return;
        } else {
            pressureChartCard.setVisibility(View.VISIBLE);
        }
        Description graphDescription = new Description();
        graphDescription.setText("");
        mPressureChart.setDescription(graphDescription);
        mPressureChart.setDrawGridBackground(false);
        mPressureChart.setTouchEnabled(true);
        mPressureChart.setDragEnabled(true);
        mPressureChart.setMaxHighlightDistance(300);
        mPressureChart.setPinchZoom(true);
        mPressureChart.getLegend().setEnabled(false);
        mPressureChart.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        mPressureChart.setGridBackgroundColor(PreferenceUtil.getTextColor(this));

        GraphUtils.setupXAxis(
                mPressureChart.getXAxis(),
                weatherForecastList.get(locationId),
                PreferenceUtil.getTextColor(this),
                null,
                PreferenceUtil.getGraphGridColor(this),
                locale);

        YAxis yLeft = mPressureChart.getAxisLeft();
        yLeft.setEnabled(true);
        yLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yLeft.setDrawAxisLine(false);
        yLeft.setDrawGridLines(true);
        yLeft.enableGridDashedLine(5f, 10f, 0f);
        yLeft.setTextColor(PreferenceUtil.getTextColor(this));
        yLeft.setGridColor(PreferenceUtil.getGraphGridColor(this).getMainGridColor());
        yLeft.setXOffset(15);
        yLeft.setValueFormatter(new YAxisValueFormatter(locale, 2, AppPreference.getPressureUnit(this)));

        mPressureChart.getAxisRight().setEnabled(false);

        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < weatherForecastList.get(locationId).size(); i++) {
            entries.add(new Entry(
                    i,
                    (float) AppPreference.getPressureWithUnit(
                            this,
                            weatherForecastList.get(locationId).get(i).getPressure(),
                            locale).getPressure()));
        }

        LineDataSet set;
        if (mPressureChart.getData() != null) {
            mPressureChart.getData().removeDataSet(mPressureChart.getData().getDataSetByIndex(
                    mPressureChart.getData().getDataSetCount() - 1));
            set = new LineDataSet(entries, getString(R.string.graph_pressure_label));
            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set.setCubicIntensity(0.2f);
            set.setDrawCircles(false);
            set.setLineWidth(2f);
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#20cb02"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            LineData data = new LineData(set);
            mPressureChart.setData(data);
        } else {
            set = new LineDataSet(entries, getString(R.string.graph_pressure_label));
            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set.setCubicIntensity(0.2f);
            set.setDrawCircles(false);
            set.setLineWidth(2f);
            set.setValueTextSize(12f);
            set.setDrawValues(false);
            set.setColor(Color.parseColor("#20cb02"));
            set.setHighlightEnabled(false);
            set.setValueFormatter(mValueFormatter);
            set.setValueTextColor(PreferenceUtil.getTextColor(this));

            LineData data = new LineData(set);
            mPressureChart.setData(data);
        }
        mPressureChart.invalidate();
    }

