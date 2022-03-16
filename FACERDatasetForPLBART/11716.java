    /**
     * {@inheritDoc}
     */
    @Override
    public SIGNAL onRequestEnd() {
        try {
            if (this.getProgramListener().getOutputStream() != null) {
                this.getProgramListener().getOutputStream().flush();
            }
        } catch (Exception ex) {/**NON BLOCK**/}
        try {
            Thread.yield();
        } catch (Exception ex) {/**NON BLOCK**/}
        return null;
    }

