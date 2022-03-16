    /**
     * Method that captures and translate an exception, showing a
     * toast or a alert, according to the importance.
     *
     * @param context The current context
     * @param ex The exception
     */
    public static synchronized void translateException(
            final Context context, Throwable ex) {
        translateException(context, ex, false, true);
    }

