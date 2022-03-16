    /**
     * Method that performs a test over the recovery of disk usage.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testDiskUsage() throws Exception {
        List<DiskUsage> du = CommandHelper.getDiskUsage(getContext(), getConsole());
        assertNotNull("diskusage==null", du); //$NON-NLS-1$
        assertTrue("no objects returned", du.size() > 0); //$NON-NLS-1$
    }

