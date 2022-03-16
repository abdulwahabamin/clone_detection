    private void humidityGraph() {
        LineChartView lineChartView = findViewById(R.id.graph_humidity);

        float minHumidity = 100000;
        float maxHumidity = 0;

        LineSet dataset = new LineSet();
        for (int i = 0; i < weatherList.size(); i++) {
            float humidity = Float.parseFloat(weatherList.get(i).getHumidity());

            minHumidity = Math.min(humidity, minHumidity);
            maxHumidity = Math.max(humidity, maxHumidity);

            dataset.addPoint(getDateLabel(weatherList.get(i), i), humidity);
        }
        dataset.setSmooth(false);
        dataset.setColor(Color.parseColor("#2196F3"));
        dataset.setThickness(4);

        int min = (int) minHumidity / 10 * 10;
        int max = (int) Math.ceil(maxHumidity / 10) * 10;
        if (min == max) {
            max = Math.min(max + 10, 100);
            min = Math.max(min - 10, 0);
        }
        int stepSize = (max - min == 100) ? 20 : 10;

        lineChartView.addData(dataset);
        lineChartView.setGrid(ChartView.GridType.HORIZONTAL, (max - min) / stepSize, 1, gridPaint);
        lineChartView.setAxisBorderValues(min, max);
        lineChartView.setStep(stepSize);
        lineChartView.setLabelsColor(Color.parseColor(labelColor));
        lineChartView.setXAxis(false);
        lineChartView.setYAxis(false);
        lineChartView.setBorderSpacing(Tools.fromDpToPx(10));
        lineChartView.show();

        BarChartView barChartView = getBackgroundBarChart(R.id.graph_humidity_background, min, max, false);
        barChartView.show();

        TextView textView = findViewById(R.id.graph_humidity_textview);
        textView.setText(String.format("%s (%s)", getString(R.string.humidity), "%"));
    }

