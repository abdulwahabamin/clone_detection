    /**
     * This method returns a ViewPropertyAnimator object, which can be used to animate specific
     * properties on this View.
     *
     * @param view View to animate.
     * @return The ViewPropertyAnimator associated with this View.
     */
    public static ViewPropertyAnimator animate(View view) {
        ViewPropertyAnimator animator = ANIMATORS.get(view);
        if (animator == null) {
            final int version = Integer.valueOf(Build.VERSION.SDK);
            if (version >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                animator = new ViewPropertyAnimatorICS(view);
            } else if (version >= Build.VERSION_CODES.HONEYCOMB) {
                animator = new ViewPropertyAnimatorHC(view);
            } else {
                animator = new ViewPropertyAnimatorPreHC(view);
            }
            ANIMATORS.put(view, animator);
        }
        return animator;
    }

