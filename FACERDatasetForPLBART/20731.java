    /**
     * Creates an VelocityScroller with flywheel enabled.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     */
    public VelocityScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

