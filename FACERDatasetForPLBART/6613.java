    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mState = new State();
        mState.action = State.ACTION_OPEN;
        mState.showAdvanced = true;
        mState.localOnly = false;
    }

