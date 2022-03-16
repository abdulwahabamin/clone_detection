    /**
     * Method that sets if the object has the sticky bit active.
     *
     * @param stickybit If the object has the sticky bit active
     */
    public void setStickybit(boolean stickybit) {
        this.mStickybit = stickybit;
        invalidateRawString();
    }

