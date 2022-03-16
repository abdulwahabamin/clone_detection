    /**
     * Method that performs a test to mount a filesystem.
     *
     * @throws Exception If test failed
     */
    @MediumTest
    public void testRemountOk() throws Exception {
        MountPoint mp = MountPointHelper.getMountPointFromDirectory(getConsole(), MOUNT_POINT_DIR);
        boolean rw = MountPointHelper.isReadWrite(mp);
        boolean ret = CommandHelper.remount(getContext(), mp, !rw, getConsole());
        MountPoint mp2 = MountPointHelper.getMountPointFromDirectory(getConsole(), MOUNT_POINT_DIR);
        boolean rw2 = MountPointHelper.isReadWrite(mp2);

        assertTrue("response==false", ret); //$NON-NLS-1$
        assertTrue(
                String.format("remount failed: expected: %s, obtain: %s", //$NON-NLS-1$
                        rw ? "rw" : "ro",  //$NON-NLS-1$ //$NON-NLS-2$
                        rw2 ? "rw " : "ro"), //$NON-NLS-1$ //$NON-NLS-2$
                rw != rw2);
    }

