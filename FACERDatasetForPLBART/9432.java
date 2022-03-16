    /**
     * Method that check if root command are present in the device
     *
     * @return boolean True if root command is present
     */
    private boolean isRootPresent() {
        try {
            String rootCommand = getString(R.string.root_command);
            File cmd = new File(rootCommand);
            if (!cmd.exists() || !cmd.isFile()) {
                Log.w(TAG,
                        String.format(
                                "Command %s not found. Exists: %s; IsFile: %s.", //$NON-NLS-1$
                                rootCommand,
                                String.valueOf(cmd.exists()),
                                String.valueOf(cmd.isFile())));
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.e(TAG,
                    "Failed to read root command.", e); //$NON-NLS-1$
        }
        return false;
    }

