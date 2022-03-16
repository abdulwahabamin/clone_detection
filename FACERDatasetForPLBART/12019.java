    /**
     * Method that returns if the current console is a privileged console
     *
     * @return boolean If the current console is a privileged console
     */
    public static boolean isPrivileged() {
        if (sHolder != null && sHolder.getConsole() instanceof PrivilegedConsole) {
            return true;
        }
        return false;
    }

