    /**
     * Method that returns if the object is hidden object.
     *
     * @return boolean If the object is hidden object
     */
    public boolean isHidden() {
        return this.mName.startsWith("."); //$NON-NLS-1$
    }

