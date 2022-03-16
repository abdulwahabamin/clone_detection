    /**
     * Method that sets if the object has the setuid bit active.
     *
     * @param setuid If the object has the setuid bit active
     */
    public void setSetUID(boolean setuid) {
        this.mSetuid = setuid;
        invalidateRawString();
    }

