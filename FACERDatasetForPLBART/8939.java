    /**
     * Method that processes a line to determine if it's a valid partial result
     *
     * @param line The line to process
     * @return String The processed line
     */
    private String processPartialResult(String line) {
        // MD5 and SHA-1 return both the digest and the name of the file
        // 4c044b884cf2ff3839713da0e81dced19f099b09  boot.zip
        int pos = line.indexOf(" "); //$NON-NLS-1$
        if (line.endsWith(this.mName) && pos != -1) {
            String digest = line.substring(0, pos).trim();
            if (this.mChecksumsCounter < this.mChecksums.length) {
                this.mChecksums[this.mChecksumsCounter] = digest;
            }
            this.mChecksumsCounter++;
            return digest;
        }
        return null;
    }

