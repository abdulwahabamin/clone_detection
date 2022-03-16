    /**
     * Method that returns if a command is present in the system
     *
     * @param commandId The command key
     * @return boolean If the command is present
     */
    public static boolean hasOptionalCommand(String commandId) {
        if (!sOptionalCommandsMap.containsKey(commandId)) {
            return false;
        }
        return sOptionalCommandsMap.get(commandId).booleanValue();
    }

