    /**
     * {@inheritDoc}
     */
    @Override
    protected void setUp() throws Exception {
        //Setup the console
        if (isRootConsoleNeeded()) {
            FileManagerApplication.changeBackgroundConsoleToPriviligedConsole();
            this.mConsole = ConsoleBuilder.createPrivilegedConsole(getContext());
        } else {
            this.mConsole = ConsoleBuilder.createNonPrivilegedConsole(getContext());
        }

        super.setUp();
    }

