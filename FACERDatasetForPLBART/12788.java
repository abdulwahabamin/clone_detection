    /**
     * Method that returns the compression mode from the user choice
     *
     * @param ctx The current context
     * @param labels The dialog labels
     * @param choice The choice of the user
     * @return CompressionMode The compression mode
     */
    static CompressionMode getCompressionModeFromUserChoice(
            Context ctx, String[] labels, int choice) {
        String label = labels[choice];
        String[] allLabels = ctx.getResources().getStringArray(R.array.compression_modes_labels);
        CompressionMode[] values = CompressionMode.values();
        int cc = allLabels.length;
        for (int i = 0; i < cc; i++) {
            if (allLabels[i].compareTo(label) == 0) {
                return values[i];
            }
        }
        return null;
    }

