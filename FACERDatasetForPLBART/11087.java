    /**
     * Method that converts the string set of color schemes to an array of colors
     *
     * @param value The string set of color schemes to parse
     * @return int[] Array of colors
     */
    public static int[] toColorShemeArray(String value) {
        if (value == null || value.length() == 0) {
            return new int[]{};
        }
        String[] values = value.split("\\|"); //$NON-NLS-1$
        int[] colors = new int[values.length];
        int cc = colors.length;
        for (int i = 0; i < cc; i++) {
            try {
                colors[i] = Integer.parseInt(values[i]);
            } catch (Exception e) {
                Log.w(TAG,
                        String.format(
                                "Problem parsing color value \"%s\" on position %d", //$NON-NLS-1$
                                values[i], Integer.valueOf(i)));
                colors[i] = 0;
            }
        }
        return colors;
    }

