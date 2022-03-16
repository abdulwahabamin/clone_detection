    /**
     * Method that sets the free disk space percentage after the widget change his color to advise
     * the user
     *
     * @param percentage The free disk space percentage
     */
    public void setFreeDiskSpaceWarningLevel(int percentage) {
        this.mDiskWarningAngle = (360 * percentage) / 100;
    }

