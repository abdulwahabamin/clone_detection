    public static void setupXAxis(XAxis x,
                                  List<DetailedWeatherForecast> weatherForecastList,
                                  int textColorId,
                                  Float textSize,
                                  AppPreference.GraphGridColors gridColor,
                                  Locale locale) {
        x.removeAllLimitLines();
        Map<Integer, Long> hourIndexes = new HashMap<>();

        int lastDayOflimitLine = 0;
        for (int i = 0; i < weatherForecastList.size(); i++) {
            hourIndexes.put(i, weatherForecastList.get(i).getDateTime());
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(weatherForecastList.get(i).getDateTime() * 1000);
            if (cal.get(Calendar.DAY_OF_YEAR) != lastDayOflimitLine) {
                Calendar calOfPreviousRecord = Calendar.getInstance();
                int previousRecordHour = 24;
                if (i > 0) {
                    calOfPreviousRecord.setTimeInMillis(weatherForecastList.get(i - 1).getDateTime() * 1000);
                    previousRecordHour = calOfPreviousRecord.get(Calendar.HOUR_OF_DAY);
                }
                int currentHour = cal.get(Calendar.HOUR_OF_DAY);
                float timeSpan = (24 - previousRecordHour) + currentHour;
                float dayLine = currentHour / timeSpan;
                float midnight = i - dayLine;
                float hour6 = midnight + (6 / timeSpan);
                float hour12 = midnight + (12 / timeSpan);
                float hour18 = midnight + (18 / timeSpan);
                LimitLine limitLine = new LimitLine(midnight);
                limitLine.setLineColor(gridColor.getMainGridColor());
                limitLine.setLineWidth(0.5f);
                x.addLimitLine(limitLine);
                /*LimitLine limitLine6 = new LimitLine(hour6, "");
                limitLine6.setLineColor(Color.LTGRAY);
                limitLine6.setLineWidth(0.5f);
                x.addLimitLine(limitLine6);*/
                LimitLine limitLine12 = new LimitLine(hour12);
                limitLine12.setLineColor(gridColor.getSecondaryGridColor());
                limitLine12.setLineWidth(0.5f);
                x.addLimitLine(limitLine12);
                /*LimitLine limitLine18 = new LimitLine(hour18, "");
                limitLine18.setLineColor(Color.LTGRAY);
                limitLine18.setLineWidth(0.5f);
                x.addLimitLine(limitLine18);*/
                lastDayOflimitLine = cal.get(Calendar.DAY_OF_YEAR);
            }
        }

        x.setEnabled(true);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setLabelCount(25, true);
        x.setTextColor(textColorId);
        x.setValueFormatter(new XAxisValueFormatter(hourIndexes, locale));
        x.setDrawLimitLinesBehindData(true);

        if (textSize != null) {
            x.setTextSize(textSize);
        }
    }

