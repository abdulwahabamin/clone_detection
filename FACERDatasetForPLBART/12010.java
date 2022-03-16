    /**
     * Method that changes the current console to a non-privileged console.
     *
     * @param context The current context
     * @return boolean If the operation was successfully
     */
    public static boolean changeToNonPrivilegedConsole(Context context) {

        //Check the current console
        if (sHolder != null && sHolder.getConsole() instanceof NonPriviledgeConsole) {
            //The current console is non-privileged. Not needed
            return true;
        }

        //Create the console
        ConsoleHolder holder = null;
        try {
            //Create the console, destroy the current console, and marks as current
            holder = new ConsoleHolder(
                    createNonPrivilegedConsole(context));
            destroyConsole();
            sHolder = holder;
            return true;

        } catch (Throwable e) {
            if (holder != null) {
                holder.dispose();
            }
        }
        return false;
    }

