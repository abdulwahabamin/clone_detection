    /**
     * Method that destroy the background console
     */
    public static void destroyBackgroundConsole() {
        try {
            sBackgroundConsole.dispose();
        } catch (Throwable ex) {
            /**NON BLOCK**/
        }
    }

