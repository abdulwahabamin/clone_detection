    /**
     * Method that prepares an argument to be executed. This method
     * ensures that the arguments no have malicious code
     *
     * @param arg Argument
     * @return String The prepared argument
     */
    public static String prepareArgument(final String arg) {
        if (arg == null) {
            return null;
        }
        String preparedArgs = arg.replace("\"", "\\\""); //$NON-NLS-1$//$NON-NLS-2$
        preparedArgs = preparedArgs.replace("$", "\\$"); //$NON-NLS-1$//$NON-NLS-2$
        return preparedArgs;
    }

