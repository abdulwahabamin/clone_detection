    /**
     * This method creates a <code>Builder</code> object, which is used to
     * set up playing constraints. This initial <code>play()</code> method
     * tells the <code>Builder</code> the animation that is the dependency for
     * the succeeding commands to the <code>Builder</code>. For example,
     * calling <code>play(a1).with(a2)</code> sets up the AnimatorSet to play
     * <code>a1</code> and <code>a2</code> at the same time,
     * <code>play(a1).before(a2)</code> sets up the AnimatorSet to play
     * <code>a1</code> first, followed by <code>a2</code>, and
     * <code>play(a1).after(a2)</code> sets up the AnimatorSet to play
     * <code>a2</code> first, followed by <code>a1</code>.
     *
     * <p>Note that <code>play()</code> is the only way to tell the
     * <code>Builder</code> the animation upon which the dependency is created,
     * so successive calls to the various functions in <code>Builder</code>
     * will all refer to the initial parameter supplied in <code>play()</code>
     * as the dependency of the other animations. For example, calling
     * <code>play(a1).before(a2).before(a3)</code> will play both <code>a2</code>
     * and <code>a3</code> when a1 ends; it does not set up a dependency between
     * <code>a2</code> and <code>a3</code>.</p>
     *
     * @param anim The animation that is the dependency used in later calls to the
     * methods in the returned <code>Builder</code> object. A null parameter will result
     * in a null <code>Builder</code> return value.
     * @return Builder The object that constructs the AnimatorSet based on the dependencies
     * outlined in the calls to <code>play</code> and the other methods in the
     * <code>Builder</code object.
     */
    public Builder play(Animator anim) {
        if (anim != null) {
            mNeedsSort = true;
            return new Builder(anim);
        }
        return null;
    }

