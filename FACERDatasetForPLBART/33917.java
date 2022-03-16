    private void pressureGraph() {
        LineChartView lineChartView = findViewById(R.id.graph_pressure);

        float minPressure = 100000;
        float maxPressure = 0;

        LineSet dataset = new LineSet();
        for (int i = 0; i < weatherList.size(); i++) {
            float pressure = UnitConvertor.convertPressure(Float.parseFloat(weatherList.get(i).getPressure()), sp);

            minPressure = Math.min(pressure, minPressure);
            maxPressure = Math.max(pressure, maxPressure);

            dataset.addPoint(getDateLabel(weatherList.get(i), i), pressure);
        }
        dataset.setSmooth(false);
        dataset.setColor(Color.parseColor("#4CAF50"));
        dataset.setThickness(4);

        int middle = Math.round(minPressure + (maxPressure - minPressure) / 2);
        int stepSize = Math.max(1, (int) Math.ceil(Math.abs(maxPressure - minPressure) / 4));
        int min = middle - 2 * stepSize;
        int max = middle + 2 * stepSize;
        int rows = 4;
        if (Math.ceil(maxPressure) - Math.floor(minPressure) <= 3) {
            min = (int) Math.floor(minPressure);
            max = Math.max(min + 1, (int) Math.ceil(maxPressure));
            rows = max - min;
        }

        lineChartView.addData(dataset);
        lineChartView.setGrid(ChartView.GridType.HORIZONTAL, rows, 1, gridPaint);
        lineChartView.setAxisBorderValues(min, max);
        lineChartView.setStep(stepSize);
        lineChartView.setLabelsColor(Color.parseColor(labelColor));
        lineChartView.setXAxis(false);
        lineChartView.setYAxis(false);
        lineChartView.setBorderSpacing(Tools.fromDpToPx(10));
        lineChartView.show();

        BarChartView barChartView = getBackgroundBarChart(R.id.graph_pressure_background, min, max, false);
        barChartView.show();

        TextView textView = findViewById(R.id.graph_pressure_textview);
        textView.setText(String.format("%s (%s)", getString(R.string.pressure), sp.getString("pressureUnit", "hPa")));
    }

