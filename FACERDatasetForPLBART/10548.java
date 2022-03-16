    /**
     * Method that returns a more human readable of a size in bytes.
     *
     * @param size The size in bytes
     * @return String The human readable size
     */
    public static String getHumanReadableSize(long size) {
        Resources res = FileManagerApplication.getInstance().getResources();
        final int[] magnitude = {
                                 R.string.size_bytes,
                                 R.string.size_kilobytes,
                                 R.string.size_megabytes,
                                 R.string.size_gigabytes
                                };

        double aux = size;
        int cc = magnitude.length;
        for (int i = 0; i < cc; i++) {
            if (aux < 1024) {
                double cleanSize = Math.round(aux * 100);
                return Double.toString(cleanSize / 100) +
                        " " + res.getString(magnitude[i]); //$NON-NLS-1$
            } else {
                aux = aux / 1024;
            }
        }
        double cleanSize = Math.round(aux * 100);
        return Double.toString(cleanSize / 100) +
                " " + res.getString(magnitude[cc - 1]); //$NON-NLS-1$
    }

