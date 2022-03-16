        /**
         * Called when the scroll state changes. Useful for discovering when the user
         * begins dragging, when the pager is automatically settling to the current page,
         * or when it is fully stopped/idle.
         *
         * @param state The new scroll state.
         * @see VelocityViewPager#SCROLL_STATE_IDLE
         * @see VelocityViewPager#SCROLL_STATE_DRAGGING
         * @see VelocityViewPager#SCROLL_STATE_SETTLING
         */
        public void onPageScrollStateChanged(int state);

