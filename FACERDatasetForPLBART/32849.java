    private static double getCosOfZenithAngle(double latitude, long timestamp) {
        Calendar measuredTime = Calendar.getInstance();
        measuredTime.setTimeInMillis(timestamp);
        double declination = Math.toRadians(-23.44 * Math.cos(Math.toRadians((360f/365f) * (9 + measuredTime.get(Calendar.DAY_OF_YEAR)))));
        double hourAngle = ((12 * 60) - (60 * measuredTime.get(Calendar.HOUR_OF_DAY) + measuredTime.get(Calendar.MINUTE))) * 0.25;
        return Math.sin(latitude)*Math.sin(declination) + (Math.cos(latitude) * Math.cos(declination) * Math.cos(Math.toRadians(hourAngle)));
    }

