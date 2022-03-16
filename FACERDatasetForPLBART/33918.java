    private void windSpeedGraph() {
        LineChartView lineChartView = findViewById(R.id.graph_windspeed);
        String graphLineColor = "#efd214";

        float maxWindSpeed = 1;

        if (darkTheme) {
            graphLineColor = "#FFF600";
        }

        LineSet dataset = new LineSet();
        for (int i = 0; i < weatherList.size(); i++) {
            float windSpeed = (float) UnitConvertor.convertWind(Float.parseFloat(weatherList.get(i).getWind()), sp);

            maxWindSpeed = Math.max(windSpeed, maxWindSpeed);

            dataset.addPoint(getDateLabel(weatherList.get(i), i), windSpeed);
        }
        dataset.setSmooth(false);
        dataset.setColor(Color.parseColor(graphLineColor));
        dataset.setThickness(4);

        int stepSize = 1;
        if (maxWindSpeed > 6) {
            maxWindSpeed = (float) Math.ceil(maxWindSpeed / 6) * 6;
            stepSize = (int) Math.ceil(maxWindSpeed / 6);
        } else {
            maxWindSpeed = (float) Math.ceil(maxWindSpeed);
        }
        int max = (int) maxWindSpeed;

        lineChartView.addData(dataset);
        lineChartView.setGrid(ChartView.GridType.HORIZONTAL, max / stepSize, 1, gridPaint);
        lineChartView.setAxisBorderValues(0, (int) maxWindSpeed);
        lineChartView.setStep(stepSize);
        lineChartView.setLabelsColor(Color.parseColor(labelColor));
        lineChartView.setXAxis(false);
        lineChartView.setYAxis(false);
        lineChartView.setBorderSpacing(Tools.fromDpToPx(10));
        lineChartView.show();

        BarChartView barChartView = getBackgroundBarChart(R.id.graph_windspeed_background, 0, max, false);
        barChartView.show();

        TextView textView = findViewById(R.id.graph_windspeed_textview);
        textView.setText(String.format("%s (%s)", getString(R.string.wind_speed), sp.getString("speedUnit", "m/s")));
    }

