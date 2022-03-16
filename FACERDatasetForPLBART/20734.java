    /**
     * Creates an VelocityScroller.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     * @param bounceCoefficientX A value between 0 and 1 that will determine the proportion of the
     * velocity which is preserved in the bounce when the horizontal edge is reached. A null value
     * means no bounce. This behavior is no longer supported and this coefficient has no effect.
     * @param bounceCoefficientY Same as bounceCoefficientX but for the vertical direction. This
     * behavior is no longer supported and this coefficient has no effect.
     * @param flywheel If true, successive fling motions will keep on increasing scroll speed.
     * !deprecated Use {!link VelocityScroller(Context, Interpolator, boolean)} instead.
     */
    public VelocityScroller(Context context, Interpolator interpolator,
                        float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
    }

