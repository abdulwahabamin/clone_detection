    /**
     * Method that initializes a console
     */
    private boolean initializeConsole() {
        try {
            // Create a ChRooted console
            ConsoleBuilder.createDefaultConsole(this, false, false);
            // There is a console allocated. Use it.
            return true;
        } catch (Throwable _throw) {
            // Capture the exception
            ExceptionUtil.translateException(this, _throw, true, false);
        }
        return false;
    }

