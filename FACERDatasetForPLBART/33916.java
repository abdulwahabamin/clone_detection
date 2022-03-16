    private void rainGraph() {
        BarChartView barChartView = findViewById(R.id.graph_rain);

        float maxRain = 1;

        BarSet dataset = new BarSet();
        for (int i = 0; i < weatherList.size(); i++) {
            float rain = UnitConvertor.convertRain(Float.parseFloat(weatherList.get(i).getRain()), sp);

            maxRain = Math.max(rain, maxRain);

            dataset.addBar(getDateLabel(weatherList.get(i), i), rain);
        }
        dataset.setColor(Color.parseColor("#2196F3"));

        int stepSize = 1;
        if (maxRain > 6) {
            maxRain = (float) Math.ceil(maxRain / 6) * 6;
            stepSize = (int) Math.ceil(maxRain / 6);
        } else {
            maxRain = (float) Math.ceil(maxRain);
        }
        int max = (int) maxRain;

        barChartView.addData(dataset);
        barChartView.setGrid(ChartView.GridType.HORIZONTAL, max / stepSize, 1, gridPaint);
        barChartView.setAxisBorderValues(0, (int) Math.ceil(maxRain));
        barChartView.setStep(stepSize);
        barChartView.setLabelsColor(Color.parseColor(labelColor));
        barChartView.setXAxis(false);
        barChartView.setYAxis(false);
        barChartView.setBorderSpacing(Tools.fromDpToPx(10));
        barChartView.show();

        BarChartView backgroundChartView = getBackgroundBarChart(R.id.graph_rain_background, 0, max, true);
        backgroundChartView.show();

        TextView textView = findViewById(R.id.graph_rain_textview);
        textView.setText(String.format("%s (%s)", getString(R.string.rain), sp.getString("lengthUnit", "mm")));
    }

