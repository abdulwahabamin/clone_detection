    /**
     * Constructor, called by View. This is private by design, as the user should only
     * get a ViewPropertyAnimator by calling View.animate().
     *
     * @param view The View associated with this ViewPropertyAnimator
     */
    ViewPropertyAnimatorHC(View view) {
        mView = new WeakReference<View>(view);
    }

