	@SmallTest
	public void testTemperatureConversionFromKelvins_toCelcius() {
		double expectedCelsius = TEMPERATURE_INPUT_IN_KELVINS
				- Temperature.DIFFERENCE_BETWEEN_KELVIN_AND_CELCIUS;
		double actualCelsius = TemperatureScale.CELSIUS
				.convertTemperature(TEMPERATURE_INPUT_IN_KELVINS);
		assertTrue(
				"Incorrect conversion to the Celsius scale: expected "
						+ expectedCelsius + ", but received " + actualCelsius,
				Math.abs(expectedCelsius - actualCelsius) < ACCEPTABLE_ROUNDING_ERROR);
	}

