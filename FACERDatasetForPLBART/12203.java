    /**
     * Method that returns the application background console.
     *
     * @return Console The background console
     */
    public static Console getBackgroundConsole() {
        if (sBackgroundConsole == null ||
            sBackgroundConsole.getConsole() == null ||
            !sBackgroundConsole.getConsole().isActive()) {

            allocBackgroundConsole(getInstance().getApplicationContext());
        }
        return sBackgroundConsole.getConsole();
    }

