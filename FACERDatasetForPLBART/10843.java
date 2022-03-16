    /**
     * Method that converts an hex string color representation to an ARGB color
     *
     * @param hex The hex string representation of the color
     * @return int The ARGB color
     */
    private static int toARGB(String hex) {
        return Color.parseColor("#" + hex); //$NON-NLS-1$
    }

