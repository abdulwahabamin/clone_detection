    /**
     * Method that performs a test to a void variable.
     * list command
     *
     * @throws Exception If test failed
     */
    @SmallTest
    public void testEchoVoid() throws Exception {
        String echo = CommandHelper.getVariable(getContext(), ECHO_MSG_VOID, getConsole());
        assertNotNull("exitCode==null", echo); //$NON-NLS-1$
        assertTrue("echo!=0", echo.length() == 0); //$NON-NLS-1$
    }

