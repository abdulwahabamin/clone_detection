    @SmallTest
    public void testSpeedConversionFromMetersPerSecond_toBeaufortForce() {
        for (int i = 0; i < ACTUAL_INPUT_IN_METERS_PER_SECOND.length; i++) {
            long expectedForce = EXPECTED_OUTPUT_IN_BEAUFORT_FORCE[i];
            long actualForce = Math.round(WindSpeedMeasurementUnit.BEAUFORT_SCALE.convertSpeed(
                    ACTUAL_INPUT_IN_METERS_PER_SECOND[i]));
            String failedAssertMessage = "Incorrect conversion to Beaufort scale: expected Force "
                    + expectedForce + ", but received Force " + actualForce;
            assertEquals(failedAssertMessage, expectedForce, actualForce);
        }
    }

