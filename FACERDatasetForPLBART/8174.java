    /**
     * Method that initializes a console
     */
    private boolean initializeConsole() {
        try {
            ConsoleBuilder.getConsole(this);
            // There is a console allocated. Use it.
            return true;
        } catch (Throwable _throw) {
            // Capture the exception
            ExceptionUtil.translateException(this, _throw, false, true);
        }
        return false;
    }

