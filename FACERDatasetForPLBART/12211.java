    /**
     * Method that check if all shell commands are present in the device
     *
     * @return boolean Check if the device has all of the shell commands
     */
    private boolean areShellCommandsPresent() {
        try {
            String shellCommands = getString(R.string.shell_required_commands);
            String[] commands = shellCommands.split(","); //$NON-NLS-1$
            int cc = commands.length;
            if (cc == 0) {
                //???
                Log.w(TAG, "No shell commands."); //$NON-NLS-1$
                return false;
            }
            for (int i = 0; i < cc; i++) {
                String c = commands[i].trim();
                if (c.length() == 0) continue;
                File cmd = new File(c);
                if (!cmd.exists() || !cmd.isFile()) {
                    Log.w(TAG,
                            String.format(
                                    "Command %s not found. Exists: %s; IsFile: %s.", //$NON-NLS-1$
                                    c,
                                    String.valueOf(cmd.exists()),
                                    String.valueOf(cmd.isFile())));
                    return false;
                }
            }
            // All commands are present
            return true;
        } catch (Exception e) {
            Log.e(TAG,
                    "Failed to read shell commands.", e); //$NON-NLS-1$
        }
        return false;
    }

