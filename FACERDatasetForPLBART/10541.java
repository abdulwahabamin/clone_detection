    /**
     * Method that ask the user for an operation and re-execution of the command.
     *
     * @param context The current context
     * @param relaunchable The exception that contains the command that must be re-executed.
     * @param listener The listener where return the relaunch result
     * @hide
     */
    static void askUser(
            final Context context,
            final RelaunchableException relaunchable,
            final boolean quiet,
            final OnRelaunchCommandResult listener) {

        //Is privileged?
        boolean isPrivileged = false;
        try {
            isPrivileged = ConsoleBuilder.getConsole(context).isPrivileged();
        } catch (Throwable ex) {
            /**NON BLOCK**/
        }

        // If console is privileged there is not need to change
        // If we are in a ChRooted environment, resolve the error without doing anymore
        if (relaunchable instanceof InsufficientPermissionsException &&
                (isPrivileged ||
                 FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) == 0)) {
            translateException(
                    context, relaunchable, quiet, false, null);

            // Operation failed
            if (listener != null) {
                listener.onFailed(relaunchable);
            }
            return;
        }
        if (relaunchable instanceof InsufficientPermissionsException &&
                !FileManagerApplication.isDeviceRooted()) {
            DialogHelper.showToast(context, R.string.root_not_available_msg,
                    Toast.LENGTH_SHORT);

            // Operation failed. Root is not available
            if (listener != null) {
                listener.onFailed(relaunchable);
            }
            return;
        }

        //Create a yes/no dialog and ask the user
        final DialogInterface.OnClickListener clickListener =
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    //Run the executable again
                    try {
                        //Prepare the system before re-launch the command
                        prepare(context, relaunchable);

                        //Re-execute the command
                        List<SyncResultExecutable> executables = relaunchable.getExecutables();
                        int cc = executables.size();
                        for (int i = 0; i < cc; i++) {
                            SyncResultExecutable executable = executables.get(i);
                            Object result = CommandHelper.reexecute(context, executable, null);
                            AsyncTask<Object, Integer, Boolean> task = relaunchable.getTask();
                            if (task != null && task.getStatus() != AsyncTask.Status.RUNNING) {
                                task.execute(result);
                            }
                        }

                        // Operation complete
                        if (listener != null) {
                            listener.onSuccess();
                        }

                    } catch (Throwable ex) {
                        //Capture the exception, this time in quiet mode, if the
                        //exception is the same
                        boolean ask = ex.getClass().getName().compareTo(
                                relaunchable.getClass().getName()) == 0;
                        translateException(context, ex, quiet, !ask, listener);

                        // Operation failed
                        if (listener != null) {
                            listener.onFailed(ex);
                        }
                    }
                } else {
                    // Operation cancelled
                    if (listener != null) {
                        listener.onCancelled();
                    }
                }
            }
        };

        AlertDialog alert = DialogHelper.createYesNoDialog(
                    context,
                    R.string.confirm_operation,
                    relaunchable.getQuestionResourceId(),
                    clickListener);

        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                // Operation cancelled
                if (listener != null) {
                    listener.onCancelled();
                }
            }
        });
        DialogHelper.delegateDialogShow(context, alert);
    }

