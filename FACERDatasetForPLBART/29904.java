    public void loadWindChart() {
        windChart.setDrawGridBackground(false);
        windChart.setBackgroundColor(Color.BLACK);
        windChart.setTouchEnabled(true);
        windChart.setDragEnabled(true);
        windChart.setMaxHighlightDistance(300);
        windChart.setPinchZoom(true);
        windChart.setPadding(2 , 2 , 2 , 2);
        windChart.getLegend().setEnabled(true);
        windChart.getLegend().setTextColor(Color.WHITE);

        YAxis yAxisRight = windChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.enableAxisLineDashedLine(2f , 4f , 2f);

        YAxis yAxisLeft = windChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.WHITE);

        XAxis x = windChart.getXAxis();
        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(Color.parseColor("#FFFFFF"));
        x.setValueFormatter(new XFormatter(dates));

        LineDataSet set;
        if (windChart.getData() != null) {
            windChart.getData().removeDataSet(windChart.getData().getDataSetByIndex(
                    windChart.getData().getDataSetCount() - 1));
            windChart.getLegend().setTextColor(Color.parseColor("#FFFFFF"));
        }
        String wind = getString(R.string.bottom_wind) + ", " + (PreferenceManager.getDefaultSharedPreferences(getContext()).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.mps) : getString(R.string.mph));
        set = new LineDataSet(windEntries, wind);
        set.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawCircles(false);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setColor(Color.RED);
        set.setHighlightEnabled(false);
        set.setValueFormatter(mValueFormatter);

        LineData data = new LineData(set);
        windChart.setData(data);

        windChart.invalidate();
    }

