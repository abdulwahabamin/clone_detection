	@SmallTest
	public void testTemperatureConversionFromKelvins_toFahrenheit() {
		double expectedFahrenheit = (TEMPERATURE_INPUT_IN_KELVINS - Temperature.DIFFERENCE_BETWEEN_KELVIN_AND_CELCIUS) * 9 / 5 + 32;
		double actualFahrenheit = TemperatureScale.FAHRENHEIT
				.convertTemperature(TEMPERATURE_INPUT_IN_KELVINS);
		assertTrue(
				"Incorrect conversion to the Fahrenheit scale: expected "
						+ expectedFahrenheit + ", but received "
						+ actualFahrenheit,
				Math.abs(expectedFahrenheit - actualFahrenheit) < ACCEPTABLE_ROUNDING_ERROR);
	}

