    /**
     * Method that returns the supported compression modes
     *
     * @param ctx The current context
     * @param fsos The list of file system objects to compress
     * @return String[] An array with the compression mode labels
     */
    private static String[] getSupportedCompressionModesLabels(
                                Context ctx, List<FileSystemObject> fsos) {
        String[] labels = ctx.getResources().getStringArray(R.array.compression_modes_labels);
        // If more than a file are requested, compression is not available
        // The same applies if the unique item is a folder
        if (fsos.size() > 1 || (fsos.size() == 1 && FileHelper.isDirectory(fsos.get(0)))) {
            ArrayList<String> validLabels = new ArrayList<String>();
            CompressionMode[] values = CompressionMode.values();
            int cc = values.length;
            for (int i = 0; i < cc; i++) {
                if (values[i].mArchive) {
                    if (values[i].mCommandId == null ||
                        FileManagerApplication.hasOptionalCommand(values[i].mCommandId)) {
                        validLabels.add(labels[i]);
                    }
                }
            }
            labels = validLabels.toArray(new String[]{});
        } else {
            // Remove optional commands
            ArrayList<String> validLabels = new ArrayList<String>();
            CompressionMode[] values = CompressionMode.values();
            int cc = values.length;
            for (int i = 0; i < cc; i++) {
                if (values[i].mCommandId == null ||
                    FileManagerApplication.hasOptionalCommand(values[i].mCommandId)) {
                    validLabels.add(labels[i]);
                }
            }
            labels = validLabels.toArray(new String[]{});
        }
        return labels;
    }

