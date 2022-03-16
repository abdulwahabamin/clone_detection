    /**
     * Method that performs a test over creating a non privileged console.
     *
     * @throws Exception If test failed
     * @{link {@link ConsoleBuilder#createNonPrivilegedConsole(android.content.Context)}
     */
    @SmallTest
    public void testCreateNonPrivilegedConsole() throws Exception {
        Console console = ConsoleBuilder.createNonPrivilegedConsole(getContext());
        try {
            assertNotNull("console==null", console); //$NON-NLS-1$
        } finally {
            try {
                console.dealloc();
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

