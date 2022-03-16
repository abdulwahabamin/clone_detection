    /**
     * Sets the TimeInterpolator for all current {@link #getChildAnimations() child animations}
     * of this AnimatorSet.
     *
     * @param interpolator the interpolator to be used by each child animation of this AnimatorSet
     */
    @Override
    public void setInterpolator(/*Time*/Interpolator interpolator) {
        for (Node node : mNodes) {
            node.animation.setInterpolator(interpolator);
        }
    }

