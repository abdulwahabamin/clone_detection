    public void loadPressureChart() {
        pressureChart.setDrawGridBackground(false);
        pressureChart.setBackgroundColor(Color.BLACK);
        pressureChart.setTouchEnabled(true);
        pressureChart.setDragEnabled(true);
        pressureChart.setMaxHighlightDistance(300);
        pressureChart.setPinchZoom(true);
        pressureChart.setPadding(2 , 2 , 2 , 2);
        pressureChart.getLegend().setEnabled(true);
        pressureChart.getLegend().setTextColor(Color.WHITE);

        YAxis yAxisRight = pressureChart.getAxisRight();
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setTextColor(Color.WHITE);
        yAxisRight.enableAxisLineDashedLine(2f , 4f , 2f);

        YAxis yAxisLeft = pressureChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.WHITE);

        XAxis x = pressureChart.getXAxis();
        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(Color.parseColor("#FFFFFF"));
        x.setValueFormatter(new XFormatter(dates));

        LineDataSet set;
        if (pressureChart.getData() != null) {
            pressureChart.getData().removeDataSet(pressureChart.getData().getDataSetByIndex(
                    pressureChart.getData().getDataSetCount() - 1));
            pressureChart.getLegend().setTextColor(Color.parseColor("#FFFFFF"));
        }
        set = new LineDataSet(pressureEntries, getString(R.string.g_pressure));
        set.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set.setCubicIntensity(0.2f);
        set.setDrawCircles(false);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        set.setValueTextSize(10f);
        set.setColor(Color.CYAN);
        set.setHighlightEnabled(false);
        set.setValueFormatter(mValueFormatter);

        LineData data = new LineData(set);
        pressureChart.setData(data);

        pressureChart.invalidate();
    }

