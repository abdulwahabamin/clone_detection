    /**
     * {@inheritDoc}
     */
    @Override
    public boolean requiresOpen() {
        if (this.mMode.compareTo(LIST_MODE.FILEINFO) == 0) {
            return !getConsole().getVirtualMountPoint().equals(new File(mSrc));
        }
        return true;
    }

