    /**
     * Returns a background chart with alternating vertical bars for each day.
     * @param id BarChartView resource id
     * @param min foreground chart min label
     * @param max foreground chart max label
     * @param includeLast true for foreground bar charts, false for foreground line charts
     * @return background bar chart
     */
    private BarChartView getBackgroundBarChart(@IdRes int id, int min, int max, boolean includeLast) {
        boolean visible = false;
        int lastHour = 25;

        // get label with biggest visual length
        if (getLengthAsString(min) > getLengthAsString(max)) {
            max = min;
        }

        BarSet barDataset = new BarSet();
        for (int i = 0; i < weatherList.size(); i++) {
            if (i != weatherList.size() - 1 || includeLast) {
                for (int j = 0; j < 3; j++) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(weatherList.get(i).getDate());
                    int hour = cal.get(Calendar.HOUR_OF_DAY);

                    // 23:00 to 0:00 new day
                    if (hour < lastHour) {
                        visible = !visible;
                    }

                    barDataset.addBar("", visible ? max : 0);
                    lastHour = hour;
                }
            }
        }
        barDataset.setColor(Color.parseColor(backgroundBarColor));
        barDataset.setAlpha(0.075f);

        BarChartView barChartView = findViewById(id);
        barChartView.addData(barDataset);
        barChartView.setBarSpacing(0); // visually join bars into on bar per day
        barChartView.setAxisBorderValues(Math.min(0, max), Math.max(0, max));
        barChartView.setLabelsColor(Color.parseColor("#00ffffff")); // fully transparent (= invisible) labels
        barChartView.setXAxis(false);
        barChartView.setYAxis(false);
        barChartView.setBorderSpacing(Tools.fromDpToPx(10));

        return barChartView;
    }

