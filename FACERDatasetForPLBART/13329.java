    /**
     * Method that captures and translate an exception, showing a
     * toast or a alert, according to the importance.
     *
     * @param context The current context.
     * @param ex The exception
     * @param quiet Don't show UI messages
     * @param askUser Ask the user when if the exception could be relaunched with other privileged
     */
    public static synchronized void translateException(
            final Context context, final Throwable ex,
            final boolean quiet, final boolean askUser) {
        translateException(context, ex, quiet, askUser, null);
    }

