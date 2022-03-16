    /**
     * Constructor, called by View. This is private by design, as the user should only
     * get a ViewPropertyAnimator by calling View.animate().
     *
     * @param view The View associated with this ViewPropertyAnimator
     */
    ViewPropertyAnimatorPreHC(View view) {
        mView = new WeakReference<View>(view);
        mProxy = AnimatorProxy.wrap(view);
    }

