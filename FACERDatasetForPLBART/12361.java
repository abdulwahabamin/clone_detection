    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mDevice == null) ? 0 : mDevice.hashCode());
        result = prime * result + mDump;
        result = prime * result
                + ((mMountPoint == null) ? 0 : mMountPoint.hashCode());
        result = prime * result
                + ((mOptions == null) ? 0 : mOptions.hashCode());
        result = prime * result + mPass;
        result = prime * result + (mRemote ? 1231 : 1237);
        result = prime * result + (mSecure ? 1231 : 1237);
        result = prime * result + ((mType == null) ? 0 : mType.hashCode());
        return result;
    }

