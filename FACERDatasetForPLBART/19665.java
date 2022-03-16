    /**
     * Creates a 3D flip animation between two views.
     *
     * @param fromView First fragment in the transition.
     * @param toView Second fragment in the transition.
     */
    public CardFlipAnimation(View fromView, View toView) {
        this.fromView = fromView;
        this.toView = toView;
 
        setDuration(400);
        setFillAfter(false);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

