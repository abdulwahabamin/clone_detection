		/**
		 * Constructs an instance of {@code PaddedNumberField}.
		 * 
		 * @param field
		 *            the field
		 * @param size
		 *            size of the output field
		 */
		PaddedNumberField(int field, int size) {
			if (size < 3) {
				// Should use UnpaddedNumberField or TwoDigitNumberField.
				throw new IllegalArgumentException();
			}
			mField = field;
			mSize = size;
		}

