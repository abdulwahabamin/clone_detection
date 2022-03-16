    /**
     * Method that close the buffer
     */
    private void closeBuffer() {
        try {
            if (this.mBuffer != null) {
                this.mBuffer.close();
            }
        } catch (Exception ex) {/**NON BLOCK**/}
        try {
            Thread.yield();
        } catch (Exception ex) {/**NON BLOCK**/}
    }

