    @Override
    public String toString() {
        if (postalCode.equals(UNKNOWN_POSTAL_CODE_VALUE)) {
            return String.format("%s (%s)", cityName, countryCode);
        } else {
            return String.format("%s, %s (%s)", cityName, postalCode, countryCode);
        }
    }

