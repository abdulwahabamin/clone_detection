    protected boolean execute( String cmd, boolean use_bb, int timeout ) {
        command = cmd;
        use_busybox = use_bb;
        wait_timeout = timeout;
        return execute();
    }

