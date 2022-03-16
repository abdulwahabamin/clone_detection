    /**
     * Method that calculate a digest of the file for the source file
     *
     * @param type The type of digest to obtain
     * @pa
     * @throws InterruptedException If the operation was cancelled
     * @throws Exception If an error occurs
     */
    private void calculateDigest(CHECKSUMS type, TFile file)
            throws InterruptedException, Exception {

        InputStream is = null;
        try {
            MessageDigest md = MessageDigest.getInstance(type.name());
            is = new TFileInputStream(file);

            // Start digesting
            byte[] data = new byte[getBufferSize()];
            int read = 0;
            while ((read = is.read(data, 0, getBufferSize())) != -1) {
                checkCancelled();
                md.update(data, 0, read);
            }
            checkCancelled();

            // Finally digest
            this.mChecksums[type.ordinal()] =
                    HexDump.toHexString(md.digest()).toLowerCase(Locale.ROOT);
            checkCancelled();
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onPartialResult(this.mChecksums[type.ordinal()]);
            }

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

