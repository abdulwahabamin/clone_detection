    /**
     * Method that performs a test over a known parse result.
     *
     * @throws Exception If test failed
     * {@link GroupsCommand#parse(String, String)}
     */
    @SuppressWarnings("static-method")
    @SmallTest
    public void testParse() throws Exception {
        GroupsCommand cmd = new GroupsCommand();
        String in =
                "shell graphics input log mount adb sdcard_rw " //$NON-NLS-1$
                + "net_bt_admin net_bt inet net_bw_stats"; //$NON-NLS-1$
        String err = ""; //$NON-NLS-1$
        cmd.parse(in, err);
        List<Group> groups = cmd.getResult();
        assertNotNull("groups==null", groups); //$NON-NLS-1$
        assertTrue("groups length!=11", groups.size() == 11); //$NON-NLS-1$
        assertTrue(
                "groups(1)!=name",  //$NON-NLS-1$
                groups.get(1).getName().compareTo("graphics") == 0); //$NON-NLS-1$
    }

