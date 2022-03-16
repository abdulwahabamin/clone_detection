    @SmallTest
    public void testSpeedConversionFromMetersPerSecond_toKilometersPerHour() {
        double expectedKph = SPEED_INPUT_IN_METERS_PER_SECOND * 3.6;
        double actualKph = WindSpeedMeasurementUnit.KILOMETERS_PER_HOUR
                .convertSpeed(SPEED_INPUT_IN_METERS_PER_SECOND);
        assertTrue("Incorrect conversion to kilometers per hour: expected "
                        + expectedKph + ", but received " + actualKph,
                Math.abs(expectedKph - actualKph) < ACCEPTABLE_ROUNDING_ERROR);
    }

