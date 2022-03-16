  private void setChartValues(List<ItemHourlyDB> itemHourlyDBList) {
    List<Entry> entries = new ArrayList<>();
    int i = 0;
    if (AppUtil.isRTL(this)) {
      int j = itemHourlyDBList.size() - 1;
      while (j >= 0) {
        entries.add(new Entry(i, (float) itemHourlyDBList.get(j).getTemp()));
        i++;
        j--;
      }
    } else {
      for (ItemHourlyDB itemHourlyDB : itemHourlyDBList) {
        entries.add(new Entry(i, (float) itemHourlyDB.getTemp()));
        i++;
      }
    }
    LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
    dataSet.setLineWidth(4f);
    dataSet.setCircleRadius(7f);
    dataSet.setHighlightEnabled(false);
    dataSet.setCircleColor(Color.parseColor("#33b5e5"));
    dataSet.setValueTextSize(12);
    dataSet.setValueTextColor(Color.WHITE);
    dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
    dataSet.setValueTypeface(typeface);
    dataSet.setValueFormatter(new ValueFormatter() {
      @Override
      public String getFormattedValue(float value) {
        return String.format(Locale.getDefault(), "%.0f", value);
      }
    });
    LineData lineData = new LineData(dataSet);
    chart.getDescription().setEnabled(false);
    chart.getAxisLeft().setDrawLabels(false);
    chart.getAxisRight().setDrawLabels(false);
    chart.getXAxis().setDrawLabels(false);
    chart.getLegend().setEnabled(false);   // Hide the legend

    chart.getXAxis().setDrawGridLines(false);
    chart.getAxisLeft().setDrawGridLines(false);
    chart.getAxisRight().setDrawGridLines(false);
    chart.getAxisLeft().setDrawAxisLine(false);
    chart.getAxisRight().setDrawAxisLine(false);
    chart.getXAxis().setDrawAxisLine(false);
    chart.setScaleEnabled(false);
    chart.setData(lineData);
    chart.animateY(1000);
  }

