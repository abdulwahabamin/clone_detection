    /**
     * Method that performs a test over groups command.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testGroups() throws Exception {
        List<Group> groups = CommandHelper.getGroups(getContext(), getConsole());
        assertNotNull("groups==null", groups); //$NON-NLS-1$
        assertTrue("size==0", groups.size() > 0); //$NON-NLS-1$
    }

