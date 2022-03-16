    /**
     * Method that dispose the console.
     */
    public void dispose() {
        try {
            if (this.mConsole != null) {
                this.mConsole.dealloc();
            }
        } catch (Exception e) {
            /**NON BLOCK**/
        }
    }

