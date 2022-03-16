    /**
     * Method that performs a test over id command.
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testId() throws Exception {
        Identity identity = CommandHelper.getIdentity(getContext(), getConsole());
        assertNotNull("identity==null", identity); //$NON-NLS-1$
        assertNotNull("user==null", identity.getUser()); //$NON-NLS-1$
        assertTrue("user!=-1", identity.getUser().getId() != -1); //$NON-NLS-1$
        assertNotNull("group==null", identity.getGroup()); //$NON-NLS-1$
        assertTrue("group!=-1", identity.getGroup().getId() != -1); //$NON-NLS-1$
    }

