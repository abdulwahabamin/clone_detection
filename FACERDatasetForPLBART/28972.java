    @Before
    public void setUp() throws Exception {
        Handler handler = mock(Handler.class);
        fetchThreadData = new FetchThreadData<>(handler);
        fetchThreadData.start();
        fetchThreadData.getLooper();
    }

