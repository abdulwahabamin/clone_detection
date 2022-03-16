    /**
     * Method that converts to bytes the string representation
     * of a size (10M, 1G, 0K, ...).
     *
     * @param size The size as a string representation
     * @return long The size in bytes
     */
    private static long toBytes(String size) {
        double bytes = Double.parseDouble(size.substring(0, size.length() - 1));
        String unit = size.substring(size.length() - 1);
        if (unit.compareToIgnoreCase("G") == 0) { //$NON-NLS-1$
            return (long)(bytes * 1024 * 1024 * 1024);
        }
        if (unit.compareToIgnoreCase("M") == 0) { //$NON-NLS-1$
            return (long)(bytes * 1024 * 1024);
        }
        if (unit.compareToIgnoreCase("K") == 0) { //$NON-NLS-1$
            return (long)(bytes * 1024);
        }

        //Don't touch
        return (long)bytes;
    }

