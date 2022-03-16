    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MountPoint other = (MountPoint) obj;
        if (mDevice == null) {
            if (other.mDevice != null)
                return false;
        } else if (!mDevice.equals(other.mDevice))
            return false;
        if (mDump != other.mDump)
            return false;
        if (mMountPoint == null) {
            if (other.mMountPoint != null)
                return false;
        } else if (!mMountPoint.equals(other.mMountPoint))
            return false;
        if (mOptions == null) {
            if (other.mOptions != null)
                return false;
        } else if (!mOptions.equals(other.mOptions))
            return false;
        if (mPass != other.mPass)
            return false;
        if (mRemote != other.mRemote)
            return false;
        if (mSecure != other.mSecure)
            return false;
        if (mType == null) {
            if (other.mType != null)
                return false;
        } else if (!mType.equals(other.mType))
            return false;
        return true;
    }

