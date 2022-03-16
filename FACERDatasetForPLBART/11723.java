    /**
     * Method that add expended arguments to the arguments. This is defined with a
     * <code>[@]</code> expression in the <code>commandArgs</code> attribute of the
     * command xml definition file.
     *
     * @param args The expanded arguments
     * @param prepare Indicates if the argument must be prepared
     */
    protected void addExpandedArguments(String[] args, boolean prepare) {
        // Don't use of regexp to avoid the need to parse of args to make it compilable.
        // Only one expanded argument of well known characters
        int pos = this.mArgs.indexOf(EXPANDED_ARGS);
        if (pos != -1) {
            int cc = args.length;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < cc; i++) {
                //Quote the arguments?
                if (prepare) {
                    sb = sb.append("\"" + //$NON-NLS-1$
                            ShellHelper.prepareArgument(args[i]) + "\""); //$NON-NLS-1$
                    sb = sb.append(" "); //$NON-NLS-1$
                } else {
                    sb = sb.append(ShellHelper.prepareArgument(args[i]));
                    sb = sb.append(" "); //$NON-NLS-1$
                }
            }

            // Replace the expanded argument
            String start = this.mArgs.substring(0, pos);
            String end = this.mArgs.substring(pos+EXPANDED_ARGS.length());
            this.mArgs = start + sb.toString() + end;
        }
    }

