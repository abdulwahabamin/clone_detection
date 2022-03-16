    /**
     * Method that converts an ARGB color to its hex string color representation
     *
     * @param argb The ARGB color
     * @return String The hex string representation of the color
     */
    private static String toHex(int argb) {
        StringBuilder sb = new StringBuilder();
        sb.append(toHexString((byte)Color.alpha(argb)));
        sb.append(toHexString((byte)Color.red(argb)));
        sb.append(toHexString((byte)Color.green(argb)));
        sb.append(toHexString((byte)Color.blue(argb)));
        return sb.toString();
    }

