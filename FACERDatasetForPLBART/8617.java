    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Getting usage for: %s", //$NON-NLS-1$
                            this.mSrc == null ? "all" : this.mSrc)); //$NON-NLS-1$
        }

        if (this.mSrc == null) {
            // Retrieve the mount points
            MountPointInfoCommand cmd = new MountPointInfoCommand(this.mMountsFile);
            cmd.setBufferSize(getBufferSize());
            cmd.setTrace(isTrace());
            cmd.execute();
            List<MountPoint> mp = cmd.getResult();

            // Get every disk usage
            for (int i = 0; i < mp.size(); i++) {
                File root = new File(mp.get(i).getMountPoint());
                this.mDisksUsage.add(createDiskUsuage(root));
            }
        } else {
            this.mDisksUsage.add(createDiskUsuage(new File(this.mSrc)));
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

