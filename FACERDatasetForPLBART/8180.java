    /**
     * Method that write the file.
     *
     * @param writer The command listener
     * @param bytes The bytes to write
     * @throws Exception If something was wrong
     */
    private void syncWrite(AsyncWriter writer, byte[] bytes) throws Exception {
        // Create the writable command
        WriteExecutable cmd =
                CommandHelper.write(this, this.mFso.getFullPath(), writer, null);

        // Obtain access to the buffer (IMP! don't close the buffer here, it's manage
        // by the command)
        OutputStream os = cmd.createOutputStream();
        try {
            // Retrieve the text from the editor
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            try {
                // Buffered write
                byte[] data = new byte[this.mBufferSize];
                int read = 0, written = 0;
                while ((read = bais.read(data, 0, this.mBufferSize)) != -1) {
                    os.write(data, 0, read);
                    written += read;
                }
                Log.i(TAG, "Bytes written: " + written); //$NON-NLS-1$
            } finally {
                try {
                    bais.close();
                } catch (Exception e) {/**NON BLOCK**/}
            }

        } finally {
            // Ok. Data is written or ensure buffer close
            cmd.end();
        }
    }

