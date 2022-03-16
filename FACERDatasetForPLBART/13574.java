    /**
     * Method that performs a test over creating a privileged console.
     *
     * @throws Exception If test failed
     * @{link {@link ConsoleBuilder#createPrivilegedConsole(android.content.Context)}
     */
    @SmallTest
    public void testCreatePrivilegedConsole() throws Exception {
        Console console = ConsoleBuilder.createPrivilegedConsole(getContext());
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

