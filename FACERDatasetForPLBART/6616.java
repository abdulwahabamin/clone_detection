    public void testMatchingRootsAudioWild() throws Exception {
        mState.acceptMimes = new String[] { "audio/*" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mAudio),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

