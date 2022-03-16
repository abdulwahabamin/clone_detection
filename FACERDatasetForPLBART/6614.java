    public void testMatchingRootsEverything() throws Exception {
        mState.acceptMimes = new String[] { "*/*" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mImages, mAudio, mDocs, mMalformed1, mMalformed2),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

