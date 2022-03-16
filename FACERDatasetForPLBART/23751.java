    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new InstrumentationTestSuite(this);  
        suite.addTestSuite(TestSongs.class);
        suite.addTestSuite(TestPlaylist.class);
        return suite;
    }

