    public ExecEngine( Context context_, Handler h, String where_, String command_, boolean use_bb, int timeout ) {
        super( h );
        context = context_;
        where = where_;
        command = command_;
        use_busybox = use_bb; 
        wait_timeout = timeout;
        result = new StringBuilder( 1024 );
    }

