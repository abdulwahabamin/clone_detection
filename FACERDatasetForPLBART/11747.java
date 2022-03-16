    /**
     * Method that processes a line to determine if it's a valid partial result
     *
     * @param line The line to process
     * @return String The processed line
     */
    private String processPartialResult(String line) {
        if (this.mMode.compareTo(Mode.A_ZIP) == 0) {
            if (line.startsWith("  adding: ")) { //$NON-NLS-1$
                int pos = line.lastIndexOf('(');
                if (pos != -1) {
                    // Remove progress
                    return line.substring(10, pos).trim();
                }
                return line.substring(10).trim();
            }
            return null;
        }
        return line;
    }

