  @Override
    public TestSuite getAllTests() {
      TestSuite suite = new InstrumentationTestSuite(this);  
      //suite.addTestSuite(MusicPlaybackStress.class);
      suite.addTestSuite(AlbumsPlaybackStress.class);
      return suite;
    }

