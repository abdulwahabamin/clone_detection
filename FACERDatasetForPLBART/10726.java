    /**
     * Method that performs a test over a known parse result.
     *
     * @throws Exception If test failed
     * {@link ListCommand#parse(String, String)}
     */
    @SuppressWarnings("static-method")
    @SmallTest
    public void testParse() throws Exception {
        DiskUsageCommand cmd = new DiskUsageCommand();
        String in = "Filesystem             Size   Used   Free   Blksize\n" + //$NON-NLS-1$
                    "/dev                   414M    48K   414M   4096\n" + //$NON-NLS-1$
                    "/mnt/asec              412M    0K    412M   4096\n" + //$NON-NLS-1$
                    "/mnt/secure/asec: Permission denied"; //$NON-NLS-1$
        String err = ""; //$NON-NLS-1$
        cmd.parse(in, err);
        List<DiskUsage> du = cmd.getResult();
        assertNotNull("diskusage==null", du); //$NON-NLS-1$
        assertTrue("length!=2", du.size() == 2); //$NON-NLS-1$
        assertTrue(
                "diskusage(1).mountpoint!=/mnt/asec", //$NON-NLS-1$
                du.get(1).getMountPoint().compareTo("/mnt/asec") == 0); //$NON-NLS-1$
        assertTrue("diskusage(0).total!=414M", du.get(0).getTotal() == 434110464L); //$NON-NLS-1$
        assertTrue("diskusage(1).used!=0M", du.get(1).getUsed() == 0L); //$NON-NLS-1$
        assertTrue("diskusage(1).free!=412M", du.get(1).getFree() == 432013312L); //$NON-NLS-1$
    }

