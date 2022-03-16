    /**
     * {@inheritDoc}
     */
    @Override
    protected void tearDown() throws Exception {
        //Deallocate console
        if (this.mConsole != null) {
            try {
                this.mConsole.dealloc();
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
        this.mConsole = null;

        super.tearDown();
    }

