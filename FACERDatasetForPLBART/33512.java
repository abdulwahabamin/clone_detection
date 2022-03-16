    /**
     * Checks the validity of the user provided text, and makes the necessary changes, or asks the
     * user to correct it.
     *
     * @param providedCoordinate coordinate, provided by a user
     * @param isLatitude         whether the provided coordinate is a latitude, or a longitude
     * @return coordinate that can be submitted for the OWM query, or null if it is invalid
     */
    private String processProvidedCoordinate(String providedCoordinate, boolean isLatitude) {
        // we split the provided number into integer and decimal parts
        String integer;
        String decimal;
        if (providedCoordinate.contains(DECIMAL_MARK)) {
            String[] decimalFraction = providedCoordinate.split(DECIMAL_MARK_REGEX);
            integer = decimalFraction[0];
            decimal = decimalFraction[1];
        } else {
            integer = providedCoordinate;
            decimal = null;
        }

        int integerPart;
        int decimalPart = 0;

        try {
            integerPart = Integer.parseInt(integer);
        } catch (NumberFormatException e) {
            invalidQueryListener.showAlertDialog(
                    R.string.coordinates_error_message_number_format);
            return null;
        }

        int minValue = isLatitude ? LATITUDE_MIN_VALUE : LONGITUDE_MIN_VALUE;
        int maxValue = isLatitude ? LATITUDE_MAX_VALUE : LONGITUDE_MAX_VALUE;
        if (integerPart < minValue || integerPart > maxValue) {
            invalidQueryListener.showAlertDialog(isLatitude ?
                    R.string.coordinates_error_message_latitude_range :
                    R.string.coordinates_error_message_longitude_range);
            return null;
        }

        if (decimal != null) {
            // we leave at most three decimal places, which is approximately 100 meters precision
            int places = Math.min(decimal.length(), 3);
            decimal = decimal.substring(0, places);
            try {
                decimalPart = Integer.parseInt(decimal);
            } catch (NumberFormatException e) {
                invalidQueryListener.showAlertDialog(
                        R.string.coordinates_error_message_number_format);
                return null;
            }
        }

        String coordinate = Integer.toString(integerPart);
        if (decimalPart > 0) {
            coordinate += DECIMAL_MARK + decimalPart;
        }
        return coordinate;
    }

