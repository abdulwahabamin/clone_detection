    /**
     * Method that performs a test over known search results.
     *
     * @throws Exception If test failed
     */
    @LargeTest
    public void testQuickFolderSearchOk() throws Exception {
        List<String> result =
                CommandHelper.quickFolderSearch(getContext(), SEARCH_EXPRESSION, getConsole());
        assertNotNull("result==null", result); //$NON-NLS-1$
        assertTrue("result.size==0", result.size() != 0); //$NON-NLS-1$
        assertTrue(
                String.format("result not contains %s", SEARCH_CONTAINS), //$NON-NLS-1$
                result.contains(SEARCH_CONTAINS));
    }

