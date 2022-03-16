    /**
     * Method that attach the checksum result to the view
     *
     * @param digest The digest value
     * @hide
     */
    synchronized void setChecksum(String digest) {
        this.mChecksums[this.mComputeStatus].setText(digest);
        this.mComputeStatus++;
    }

