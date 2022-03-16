    /**
     * Method that returns if the mountpoint belongs to a virtual filesystem.
     *
     * @return boolean If the mountpoint belongs to a virtual filesystem.
     */
    public boolean isVirtual() {
        return mSecure || mRemote;
    }

