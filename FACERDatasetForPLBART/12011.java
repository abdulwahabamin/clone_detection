    /**
     * Method that changes the current console to a privileged console.
     *
     * @param context The current context
     * @return boolean If the operation was successfully
     */
    public static boolean changeToPrivilegedConsole(Context context) {

        //Destroy and create the new console
        if (sHolder != null && sHolder.getConsole() instanceof PrivilegedConsole) {
            //The current console is privileged. Not needed
            return true;
        }

        //Create the console
        ConsoleHolder holder = null;
        try {
            //Create the console, destroy the current console, and marks as current
            holder = new ConsoleHolder(
                    createAndCheckPrivilegedConsole(context));
            destroyConsole();
            sHolder = holder;

            // Change also the background console to privileged
            FileManagerApplication.changeBackgroundConsoleToPriviligedConsole();

            return sHolder.getConsole() instanceof PrivilegedConsole;

        } catch (Throwable e) {
            destroyConsole();
            if (holder != null) {
                holder.dispose();
            }
        }
        return false;
    }

