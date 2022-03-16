    /**
     * {@inheritDoc}
     */
    @Override
    public DiskUsageExecutable createDiskUsageExecutable() throws CommandNotFoundException {
        String mountsFile = this.mConsole.getCtx().getString(R.string.mounts_file);
        return new DiskUsageCommand(mountsFile);
    }

