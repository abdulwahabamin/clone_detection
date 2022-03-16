    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        int valuesIndex = (int) value;
        Long dataTime = hourIndexes.get(valuesIndex);
        if (dataTime == null) {
            return "";
        }
        calendar.setTimeInMillis(dataTime * 1000);
        int currentHourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if (((lastDayUsed == null) || (lastDayUsed != calendar.get(Calendar.DAY_OF_YEAR))) &&
                (currentHourOfDay >= 10) && (currentHourOfDay <= 14)) {
            lastDayUsed = calendar.get(Calendar.DAY_OF_YEAR);
            return format.format(calendar.getTime());
        } else {
            return "";
        }
    }

