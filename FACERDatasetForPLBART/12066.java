    /**
     * Return an instance of the current console
     * @return
     */
    public static synchronized SecureConsole getInstance(Context ctx, int bufferSize) {
        if (sConsole == null) {
            sConsole = new SecureConsole(ctx, bufferSize);
        }
        return sConsole;
    }

