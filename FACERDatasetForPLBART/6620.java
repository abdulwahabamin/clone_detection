    public void testMatchingRootsApplication() throws Exception {
        mState.acceptMimes = new String[] { "application/*" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mAudio, mDocs),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

