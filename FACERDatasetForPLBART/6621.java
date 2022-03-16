    public void testMatchingRootsFlacOrPng() throws Exception {
        mState.acceptMimes = new String[] { "application/x-flac", "image/png" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mAudio, mImages),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

