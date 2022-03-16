    public void loadSnowChart() {
        snowChart.setDrawGridBackground(false);
        snowChart.setBackgroundColor(Color.BLACK);
        snowChart.setTouchEnabled(true);
        snowChart.setDragEnabled(true);
        snowChart.setMaxHighlightDistance(300);
        snowChart.setPinchZoom(true);
        snowChart.setPadding(2 , 2 , 2 , 2);
        snowChart.getLegend().setEnabled(true);
        snowChart.getLegend().setTextColor(Color.WHITE);

        YAxis yAxisRight = snowChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.enableAxisLineDashedLine(2f , 4f , 2f);

        YAxis yAxisLeft = snowChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.WHITE);

        XAxis x = snowChart.getXAxis();
        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(Color.parseColor("#FFFFFF"));
        x.setValueFormatter(new XFormatter(dates));

        LineDataSet set;
        if (snowChart.getData() != null) {
            snowChart.getData().removeDataSet(snowChart.getData().getDataSetByIndex(
                    snowChart.getData().getDataSetCount() - 1));
            snowChart.getLegend().setTextColor(Color.parseColor("#FFFFFF"));
        }
        set = new LineDataSet(snowEntries, getString(R.string.g_snow));
        set.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawCircles(false);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setColor(Color.YELLOW);
        set.setHighlightEnabled(false);
        set.setValueFormatter(mValueFormatter);

        LineData data = new LineData(set);
        snowChart.setData(data);

        snowChart.invalidate();
    }

