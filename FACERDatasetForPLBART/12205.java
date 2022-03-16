    /**
     * Method that allocate a new background console
     *
     * @param ctx The current context
     */
    private static synchronized void allocBackgroundConsole(Context ctx) {
        try {
            // Dispose the current console
            if (sBackgroundConsole != null) {
                sBackgroundConsole.dispose();
                sBackgroundConsole = null;
            }

            //Create a console for background tasks
            if (ConsoleBuilder.isPrivileged()) {
                sBackgroundConsole =
                        new ConsoleHolder(
                                ConsoleBuilder.createPrivilegedConsole(ctx));
            } else {
                sBackgroundConsole =
                        new ConsoleHolder(
                                ConsoleBuilder.createNonPrivilegedConsole(ctx));
            }
        } catch (Exception e) {
            Log.e(TAG,
                    "Background console creation failed. " +  //$NON-NLS-1$
                    "This probably will cause a force close.", e); //$NON-NLS-1$
        }
    }

