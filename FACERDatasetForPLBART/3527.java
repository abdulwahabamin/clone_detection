    /**
     * Sets the target object for all current {@link #getChildAnimations() child animations}
     * of this AnimatorSet that take targets ({@link ObjectAnimator} and
     * AnimatorSet).
     *
     * @param target The object being animated
     */
    @Override
    public void setTarget(Object target) {
        for (Node node : mNodes) {
            Animator animation = node.animation;
            if (animation instanceof AnimatorSet) {
                ((AnimatorSet)animation).setTarget(target);
            } else if (animation instanceof ObjectAnimator) {
                ((ObjectAnimator)animation).setTarget(target);
            }
        }
    }

