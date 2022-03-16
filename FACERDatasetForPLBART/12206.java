    /**
     * Method that changes the background console to a privileged console
     *
     * @throws ConsoleAllocException If the console can't be allocated
     */
    public static void changeBackgroundConsoleToPriviligedConsole()
            throws ConsoleAllocException {
        if (sBackgroundConsole == null ||
              !(sBackgroundConsole.getConsole() instanceof PrivilegedConsole)) {
            try {
                if (sBackgroundConsole != null) {
                    sBackgroundConsole.dispose();
                }
            } catch (Throwable ex) {/**NON BLOCK**/}

            // Change the privileged console
            try {
                sBackgroundConsole =
                        new ConsoleHolder(
                                ConsoleBuilder.createPrivilegedConsole(
                                        getInstance().getApplicationContext()));
            } catch (Exception e) {
                try {
                    if (sBackgroundConsole != null) {
                        sBackgroundConsole.dispose();
                    }
                } catch (Throwable ex) {/**NON BLOCK**/}
                sBackgroundConsole = null;
                throw new ConsoleAllocException(
                        "Failed to alloc background console", e); //$NON-NLS-1$
            }
        }
    }

