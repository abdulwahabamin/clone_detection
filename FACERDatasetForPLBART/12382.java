    /**
     * Method that sets if the object can be written.
     *
     * @param write If the object can be written
     */
    public void setWrite(boolean write) {
        this.mWrite = write;
        invalidateRawString();
    }

