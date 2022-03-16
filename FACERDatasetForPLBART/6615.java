    public void testMatchingRootsPngOrWild() throws Exception {
        mState.acceptMimes = new String[] { "image/png", "*/*" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mImages, mAudio, mDocs, mMalformed1, mMalformed2),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

