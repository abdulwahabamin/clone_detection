    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instrumentation = getInstrumentation();
        setActivityInitialTouchMode(false);
        mainActivity = getActivity();
    }

