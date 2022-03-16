    /**
     * Method that performs a test over the recovery of the mount points.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testMountPoint() throws Exception {
        List<MountPoint> mp = CommandHelper.getMountPoints(getContext(), getConsole());
        assertNotNull("mountpoints==null", mp); //$NON-NLS-1$
        assertTrue("no objects returned", mp.size() > 0); //$NON-NLS-1$
    }

