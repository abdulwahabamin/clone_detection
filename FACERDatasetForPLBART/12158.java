    /**
     * Constructor of <code>VirtualConsole</code>
     *
     * @param ctx The current context
     */
    public VirtualConsole(Context ctx) {
        super();
        mCtx = ctx;
        mIdentity = AIDHelper.createVirtualIdentity();
    }

