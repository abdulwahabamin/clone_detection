    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onRequestWrite(
            byte[] data, int offset, int byteCount) throws ExecutionException {
        try {
            // Method that write to the stdin the data requested by the program
            if (this.mOut != null) {
                this.mOut.write(data, offset, byteCount);
                this.mOut.flush();
                Thread.yield();
                return true;
            }
        } catch (Exception ex) {
            String msg = String.format("Unable to write data to program: %s", //$NON-NLS-1$
                                                this.mActiveCommand.getCommand());
            Log.e(TAG, msg, ex);
            throw new ExecutionException(msg, ex);
        }
        return false;
    }

