    /**
     * Slides down the album art to hide lyrics.
     */
    private void hideLyrics() {
        TranslateAnimation slideDownAnimation = new TranslateAnimation(coverArt, 400, new DecelerateInterpolator(2.0f),
                                                                       View.VISIBLE,
                                                                       Animation.RELATIVE_TO_SELF, 0.0f,
                                                                       Animation.RELATIVE_TO_SELF, 0.0f,
                                                                       Animation.RELATIVE_TO_SELF, -2.0f,
                                                                       Animation.RELATIVE_TO_SELF, 0.0f);

        slideDownAnimation.animate();
    }

