    public void loadTemperatureChart() {
        temperatureChart.setDrawGridBackground(false);
        temperatureChart.setBackgroundColor(Color.BLACK);
        temperatureChart.setTouchEnabled(true);
        temperatureChart.setDragEnabled(true);
        temperatureChart.setMaxHighlightDistance(300);
        temperatureChart.setPinchZoom(true);
        temperatureChart.setPadding(2 , 2 , 2 , 2);
        temperatureChart.getLegend().setEnabled(true);
        temperatureChart.getLegend().setTextColor(Color.WHITE);

        YAxis yAxisRight = temperatureChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.enableAxisLineDashedLine(2f , 4f , 2f);

        YAxis yAxisLeft = temperatureChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.WHITE);

        XAxis x = temperatureChart.getXAxis();
        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(Color.parseColor("#FFFFFF"));
        x.setValueFormatter(new XFormatter(dates));

        LineDataSet set;
        if (temperatureChart.getData() != null) {
            temperatureChart.getData().removeDataSet(temperatureChart.getData().getDataSetByIndex(
                    temperatureChart.getData().getDataSetCount() - 1));
            temperatureChart.getLegend().setTextColor(Color.parseColor("#FFFFFF"));
        }
        String temp = getString(R.string.pref_temp_header) + ", " + (PreferenceManager.getDefaultSharedPreferences(getContext()).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.c) : getString(R.string.f));
        set = new LineDataSet(tempEntries, temp);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawCircles(false);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setColor(Color.MAGENTA);
        set.setHighlightEnabled(false);
        set.setValueFormatter(mValueFormatter);

        LineData data = new LineData(set);
        temperatureChart.setData(data);

        temperatureChart.invalidate();
    }

