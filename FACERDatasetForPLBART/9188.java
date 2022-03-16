    /**
     * Method that processes a line to determine if it's a valid partial result
     *
     * @param line The line to process
     * @return String The processed line
     */
    private String processPartialResult(String line) {
        if (this.mMode.compareTo(Mode.A_UNRAR) == 0) {
            if (line.startsWith("Extracting  ")) { //$NON-NLS-1$
                int pos = line.indexOf((char)8);
                if (pos != -1) {
                    // Remove progress
                    return line.substring(12, pos).trim();
                }
                return line.substring(12).trim();
            }
            return null;
        }

        if (this.mMode.compareTo(Mode.A_UNZIP) == 0) {
            if (line.startsWith("  inflating: ")) { //$NON-NLS-1$
                return line.substring(13).trim();
            }
            return null;
        }

        return line;
    }

