    /**
     * Method that sets if the object has the setgid bit active.
     *
     * @param setgid If the object has the setgid bit active
     */
    public void setSetGID(boolean setgid) {
        this.mSetGid = setgid;
        invalidateRawString();
    }

