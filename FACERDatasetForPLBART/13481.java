    /**
     * Method that converts to a visual printable hex string
     *
     * @param string The string to check
     */
    public static String toHexPrintableString(byte[] data) {
        String hexLineSeparator =  UUID.randomUUID().toString() + UUID.randomUUID().toString();
        String hex = toHexDump(data, hexLineSeparator);

        // Remove characters without visual representation
        final String REPLACED_SYMBOL = "."; //$NON-NLS-1$
        final String NEWLINE = System.getProperty("line.separator"); //$NON-NLS-1$
        String printable = hex.replaceAll("\\p{Cntrl}", REPLACED_SYMBOL); //$NON-NLS-1$
        printable = printable.replaceAll("[^\\p{Print}]", REPLACED_SYMBOL); //$NON-NLS-1$
        printable = printable.replaceAll("\\p{C}", REPLACED_SYMBOL); //$NON-NLS-1$
        printable = printable.replaceAll(hexLineSeparator, NEWLINE);
        return printable;
    }

