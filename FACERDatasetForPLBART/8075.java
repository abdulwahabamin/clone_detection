    /**
     * Method that converts a byte into its hex string representation
     *
     * @param v The value to convert
     * @return String The hex string representation
     */
    private static String toHexString(byte v) {
        String hex = Integer.toHexString(v & 0xff);
        if (hex.length() == 1) {
            hex = "0" + hex; //$NON-NLS-1$
        }
        return hex.toUpperCase();
    }

