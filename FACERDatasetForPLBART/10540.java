    /**
     * Method that captures and translate an exception, showing a
     * toast or a alert, according to the importance.
     *
     * @param context The current context.
     * @param ex The exception
     * @param quiet Don't show UI messages
     * @param askUser Ask the user when if the exception could be relaunched with other privileged
     * @param listener The listener where return the relaunch result
     */
    public static synchronized void translateException(
            final Context context, final Throwable ex,
            final boolean quiet, final boolean askUser,
            final OnRelaunchCommandResult listener) {

        // Is cancellable?
        if (ex instanceof CancelledOperationException) {
            return;
        }

        //Get the appropriate message for the exception
        int msgResId = R.string.msgs_unknown;
        boolean toast = true;

        // If an ExecutionException has specified a resource string to use,
        // this is a special case and should be displayed as such.
        if ((ex instanceof ExecutionException)
            && ((ExecutionException)ex).getDetailMessageResId() != 0) {
            msgResId = ((ExecutionException)ex).getDetailMessageResId();
        } else {
            int cc = KNOWN_EXCEPTIONS.length;
            for (int i = 0; i < cc; i++) {
                if (KNOWN_EXCEPTIONS[i].getCanonicalName().compareTo(
                        ex.getClass().getCanonicalName()) == 0) {
                    msgResId = KNOWN_EXCEPTIONS_IDS[i];
                    toast = KNOWN_EXCEPTIONS_TOAST[i];
                    break;
                }
            }
        }

        //Check exceptions that can be asked to user
        if (ex instanceof RelaunchableException && askUser) {
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    askUser(context, (RelaunchableException)ex, quiet, listener);
                }
            });
            return;
        }

        //Audit the exception
        Log.e(context.getClass().getSimpleName(), "Error detected", ex); //$NON-NLS-1$

        //Build the alert
        final int fMsgResId = msgResId;
        final boolean fToast = toast;
        if (!quiet) {
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String msg = null;
                        if (fMsgResId > 0) {
                            msg = context.getString(fMsgResId);
                        } else {
                            msg = ex.getMessage();
                        }
                        if (fToast) {
                            DialogHelper.showToast(context, msg, Toast.LENGTH_SHORT);
                        } else {
                            AlertDialog dialog =
                                    DialogHelper.createErrorDialog(
                                            context, R.string.error_title, msg);
                            DialogHelper.delegateDialogShow(context, dialog);
                        }
                    } catch (Exception e) {
                        Log.e(context.getClass().getSimpleName(),
                                "ExceptionUtil. Failed to show dialog", ex); //$NON-NLS-1$
                    }
                }
            });
        }
    }

