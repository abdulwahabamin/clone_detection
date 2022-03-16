    /**
     * Method that executes a {@link FileSystemObject} and show the output in the console
     * dialog.
     *
     * @param ctx The current context
     * @param fso The file system object
     */
    public static void execute(
            final Context ctx, final FileSystemObject fso) {
        try {
            // Create a console dialog for display the script output
            final ExecutionDialog dialog = new ExecutionDialog(ctx, fso);
            dialog.show();

            Thread t = new Thread() {
                @Override
                public void run() {
                    final ExecutionListener listener = new ExecutionListener(dialog);
                    try {
                        Thread.sleep(250L);

                        // Execute the script
                        ExecExecutable cmd =
                                CommandHelper.exec(
                                ctx, fso.getFullPath(), listener, null);
                        dialog.setCmd(cmd);
                    } catch (Exception e) {
                        listener.onException(e);
                    }
                }
            };
            t.start();

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

