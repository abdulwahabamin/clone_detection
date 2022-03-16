    @SuppressWarnings("boxing")
    private void loadOptionalCommands() {
        try {
            sOptionalCommandsMap = new HashMap<String, Boolean>();

            String shellCommands = getString(R.string.shell_optional_commands);
            String[] commands = shellCommands.split(","); //$NON-NLS-1$
            int cc = commands.length;
            if (cc == 0) {
                Log.w(TAG, "No optional commands."); //$NON-NLS-1$
                return;
            }
            for (int i = 0; i < cc; i++) {
                String c = commands[i].trim();
                String key = c.substring(0, c.indexOf("=")).trim(); //$NON-NLS-1$
                c = c.substring(c.indexOf("=")+1).trim(); //$NON-NLS-1$
                if (c.length() == 0) continue;
                File cmd = new File(c);
                Boolean found = Boolean.valueOf(cmd.exists() && cmd.isFile());
                sOptionalCommandsMap.put(key, found);
                if (DEBUG) {
                    Log.w(TAG,
                            String.format(
                                    "Optional command %s %s.", //$NON-NLS-1$
                                    c, found ? "found" : "not found")); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        } catch (Exception e) {
            Log.e(TAG,
                    "Failed to read optional shell commands.", e); //$NON-NLS-1$
        }
    }

