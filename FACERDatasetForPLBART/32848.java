    public static float getApparentTemperatureWithSolarIrradiation(double dryBulbTemperature,
                                                                   int humidity,
                                                                   double windSpeed,
                                                                   int cloudiness,
                                                                   double latitude,
                                                                   long timestamp) {
        double e = (humidity / 100f) * 6.105 * Math.exp((17.27*dryBulbTemperature / (237.7 + dryBulbTemperature)));
        double cosOfZenithAngle = getCosOfZenithAngle(Math.toRadians(latitude), timestamp);
        double secOfZenithAngle = 1/cosOfZenithAngle;
        double transmissionCoefficient = transmissionCoefficientClearDay -
                (transmissionCoefficientClearDay - transmissionCoefficientCloudy) * (cloudiness/100f);
        double calculatedIrradiation = 0;
        if (cosOfZenithAngle > 0) {
            calculatedIrradiation = (SOLAR_CONSTANT * cosOfZenithAngle*Math.pow(transmissionCoefficient, secOfZenithAngle))/10;
        }
        double apparentTemperature = dryBulbTemperature + (0.348 * e) - (0.70 * windSpeed) + ((0.70 * calculatedIrradiation)/(windSpeed + 10)) - 4.25;
        return (float)apparentTemperature;
    }

