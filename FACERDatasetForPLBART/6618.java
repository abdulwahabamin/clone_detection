    public void testMatchingRootsAudioSpecific() throws Exception {
        mState.acceptMimes = new String[] { "audio/mpeg" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mAudio),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

