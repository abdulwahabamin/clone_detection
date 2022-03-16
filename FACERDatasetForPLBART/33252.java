    @SmallTest
    public void testSpeedConversionFromMetersPerSecond_toMilesPerHour() {
        double expectedMph = SPEED_INPUT_IN_METERS_PER_SECOND * 3600 / 1609.34;
        double actualMph = WindSpeedMeasurementUnit.MILES_PER_HOUR
                .convertSpeed(SPEED_INPUT_IN_METERS_PER_SECOND);
        assertTrue("Incorrect conversion to miles per hour: expected "
                        + expectedMph + ", but received " + actualMph,
                Math.abs(expectedMph - actualMph) < ACCEPTABLE_ROUNDING_ERROR);
    }

