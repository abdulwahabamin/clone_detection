    public void testMatchingRootsAudioWildOrImageWild() throws Exception {
        mState.acceptMimes = new String[] { "audio/*", "image/*" };
        assertContainsExactly(
                Lists.newArrayList(mNull, mWild, mAudio, mImages),
                RootsCache.getMatchingRoots(mRoots, mState));
    }

