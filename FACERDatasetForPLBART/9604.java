    /**
     * Method that sets if the object can be executed.
     *
     * @param execute If the object can be executed
     */
    public void setExecute(boolean execute) {
        this.mExecute = execute;
        invalidateRawString();
    }

