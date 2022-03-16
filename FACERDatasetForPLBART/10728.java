    /**
     * Method that performs a test to get the a variable.
     * list command
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testEchoOk() throws Exception {
        String echo = CommandHelper.getVariable(getContext(), ECHO_MSG, getConsole());
        assertNotNull("echo==null", echo); //$NON-NLS-1$
    }

