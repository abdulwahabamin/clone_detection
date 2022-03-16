    private void temperatureGraph() {
        LineChartView lineChartView = findViewById(R.id.graph_temperature);

        float minTemp = 1000;
        float maxTemp = -1000;

        LineSet lineDataset = new LineSet();
        for (int i = 0; i < weatherList.size(); i++) {
            float temperature = UnitConvertor.convertTemperature(Float.parseFloat(weatherList.get(i).getTemperature()), sp);

            minTemp = Math.min(temperature, minTemp);
            maxTemp = Math.max(temperature, maxTemp);

            lineDataset.addPoint(getDateLabel(weatherList.get(i), i), temperature);
        }
        lineDataset.setSmooth(false);
        lineDataset.setColor(Color.parseColor("#FF5722"));
        lineDataset.setThickness(4);

        int middle = Math.round(minTemp + (maxTemp - minTemp) / 2);
        int stepSize = Math.max(1, (int) Math.ceil(Math.abs(maxTemp - minTemp) / 4));
        int min = middle - 2 * stepSize;
        int max = middle + 2 * stepSize;

        lineChartView.addData(lineDataset);
        lineChartView.setGrid(ChartView.GridType.HORIZONTAL, 4, 1, gridPaint);
        lineChartView.setAxisBorderValues(min, max);
        lineChartView.setStep(stepSize);
        lineChartView.setLabelsColor(Color.parseColor(labelColor));
        lineChartView.setXAxis(false);
        lineChartView.setYAxis(false);
        lineChartView.setBorderSpacing(Tools.fromDpToPx(10));
        lineChartView.show();

        BarChartView backgroundChartView = getBackgroundBarChart(R.id.graph_temperature_background, min, max, false);
        backgroundChartView.show();

        TextView textView = findViewById(R.id.graph_temperature_textview);
        textView.setText(String.format("%s (%s)", getString(R.string.temperature), sp.getString("unit", "°C")));
    }

