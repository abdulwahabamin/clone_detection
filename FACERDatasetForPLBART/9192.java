    /**
     * Method that returns the uncompression mode from the compressed file
     *
     * @param src The compressed file
     * @return Mode The uncompression mode. <code>null</code> if no mode found
     */
    private static Mode getMode(String src) {
        String extension = FileHelper.getExtension(src);
        Mode[] modes = Mode.values();
        int cc = modes.length;
        for (int i = 0; i < cc; i++) {
            Mode mode = modes[i];
            if (mode.mMode.mExtension.compareToIgnoreCase(extension) == 0) {
                return mode;
            }
        }
        return null;
    }

