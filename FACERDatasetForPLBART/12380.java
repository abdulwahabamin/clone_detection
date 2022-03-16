    /**
     * Method that sets if the object can be read.
     *
     * @param read If the object can be read
     */
    public void setRead(boolean read) {
        this.mRead = read;
        invalidateRawString();
    }

