    public void loadRainChart() {
        rainChart.setDrawGridBackground(false);
        rainChart.setBackgroundColor(Color.BLACK);
        rainChart.setTouchEnabled(true);
        rainChart.setDragEnabled(true);
        rainChart.setMaxHighlightDistance(300);
        rainChart.setPinchZoom(true);
        rainChart.setPadding(2 , 2 , 2 , 2);
        rainChart.getLegend().setEnabled(true);
        rainChart.getLegend().setTextColor(Color.WHITE);

        YAxis yAxisRight = rainChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.enableAxisLineDashedLine(2f , 4f , 2f);

        YAxis yAxisLeft = rainChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.WHITE);

        XAxis x = rainChart.getXAxis();
        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(Color.parseColor("#FFFFFF"));
        x.setValueFormatter(new XFormatter(dates));

        LineDataSet set;
        if (rainChart.getData() != null) {
            rainChart.getData().removeDataSet(rainChart.getData().getDataSetByIndex(
                    rainChart.getData().getDataSetCount() - 1));
            rainChart.getLegend().setTextColor(Color.parseColor("#FFFFFF"));
        }
        set = new LineDataSet(rainEntries, getString(R.string.bottom_rain) + "," + getString(R.string.mm));
        set.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawCircles(false);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setColor(Color.GREEN);
        set.setHighlightEnabled(false);
        set.setValueFormatter(mValueFormatter);

        LineData data = new LineData(set);
        rainChart.setData(data);

        rainChart.invalidate();
    }

