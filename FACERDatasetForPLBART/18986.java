    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (scrollingFirstTime) {
            picasso.continueDispatching();
            scrollingFirstTime = false;
        }

        //Intercept this method here if we don't need imagel loading to be paused while scrolling.
        if (scrollState==SCROLL_STATE_TOUCH_SCROLL && pauseOnScroll==false) {
            return;
        }

        //Intercept this method here if we don't need imagel loading to be paused while flinging.
        if (scrollState==SCROLL_STATE_FLING && pauseOnFling==false) {
            return;
        }

        if (!isScrolling(scrollState) && isScrolling(previousScrollState)) {
            picasso.continueDispatching();
        }

        if (isScrolling(scrollState) && !isScrolling(previousScrollState)) {
            picasso.interruptDispatching();
        }

        previousScrollState = scrollState;

        // Forward to the delegate
        if (delegate != null) {
            delegate.onScrollStateChanged(view, scrollState);
        }

    }

