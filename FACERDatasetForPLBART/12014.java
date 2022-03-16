    /**
     * Method that destroy the current console.
     */
    public static void destroyConsole() {
        try {
            if (sHolder != null) {
                sHolder.dispose();
            }
        } catch (Exception e) {
            /**NON BLOCK**/
        }
        sHolder = null;
    }

