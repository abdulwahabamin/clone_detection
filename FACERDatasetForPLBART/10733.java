    /**
     * Method that performs a test over known search results.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testFindWithPartialResult() throws Exception {
        this.mNewPartialData = false;
        this.mNormalEnd = false;
        Query query = new Query().setSlot(FIND_TERM_PARTIAL, 0);
        final List<FileSystemObject> files = new ArrayList<FileSystemObject>();
        AsyncResultExecutable cmd =
                CommandHelper.findFiles(getContext(), FIND_PATH,
                        query, new ConcurrentAsyncResultListener() {

                        @Override
                        public void onConcurrentAsyncStart() {
                            /**NON BLOCK**/
                        }
                        @Override
                        public void onConcurrentAsyncEnd(boolean cancelled) {
                            synchronized (FindCommandTest.this.mSync) {
                                FindCommandTest.this.mNormalEnd = true;
                                FindCommandTest.this.mSync.notify();
                            }
                        }
                        @Override
                        public void onConcurrentAsyncExitCode(int exitCode) {
                            /**NON BLOCK**/
                        }
                        @Override
                        public void onConcurrentException(Exception cause) {
                            fail(String.valueOf(cause));
                        }
                        @Override
                        @SuppressWarnings("unchecked")
                        public void onConcurrentPartialResult(Object results) {
                            FindCommandTest.this.mNewPartialData = true;
                            files.addAll((List<FileSystemObject>)results);
                        }
                   }, getConsole());
        synchronized (FindCommandTest.this.mSync) {
            FindCommandTest.this.mSync.wait(15000L);
        }
        try {
            if (!this.mNormalEnd && cmd != null && cmd.isCancellable() && !cmd.isCancelled()) {
                cmd.cancel();
            }
        } catch (Exception e) {/**NON BLOCK**/}
        assertTrue("no new partial data", this.mNewPartialData); //$NON-NLS-1$
        assertNotNull("files==null", files); //$NON-NLS-1$
        assertTrue("no objects returned", files.size() > 0); //$NON-NLS-1$
        boolean found = false;
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = files.get(i);
            if (fso.getParent().compareTo(TEST_FILE.getParent()) == 0 &&
                fso.getName().compareTo(TEST_FILE.getName()) == 0) {
                found = true;
            }
        }
        assertTrue(String.format("test file %s not found", TEST_FILE), found); //$NON-NLS-1$
    }

