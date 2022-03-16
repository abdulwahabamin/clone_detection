    public void testMatchingRootsDocument() throws Exception {
        mState.acceptMimes = new String[] { "application/msword" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mDocs),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

