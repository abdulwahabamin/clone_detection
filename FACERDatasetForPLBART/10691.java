    /**
     * Create a hex dump of the data while show progress to user
     *
     * @param data The data to hex dump
     * @param hexLineSeparator Internal line separator
     * @return StringBuilder The hex dump buffer
     */
    private static String toHexDump(byte[] data, String hexLineSeparator) {
        final int DISPLAY_SIZE = 16;  // Bytes per line
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        byte[] line = new byte[DISPLAY_SIZE];
        int read = 0;
        int offset = 0;
        StringBuilder sb = new StringBuilder();
        while ((read = bais.read(line, 0, DISPLAY_SIZE)) != -1) {
            //offset   dump(16)   data\n
            String linedata = new String(line, 0, read);
            sb.append(HexDump.toHexString(offset));
            sb.append(" "); //$NON-NLS-1$
            String hexDump = HexDump.toHexString(line, 0, read);
            if (hexDump.length() != (DISPLAY_SIZE * 2)) {
                char[] array = new char[(DISPLAY_SIZE * 2) - hexDump.length()];
                Arrays.fill(array, ' ');
                hexDump += new String(array);
            }
            sb.append(hexDump);
            sb.append(" "); //$NON-NLS-1$
            sb.append(linedata);
            sb.append(hexLineSeparator);
            offset += DISPLAY_SIZE;
        }

        return sb.toString();
    }

