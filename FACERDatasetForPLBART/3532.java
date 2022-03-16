    /**
     * Returns true if any of the child animations of this AnimatorSet have been started and have
     * not yet ended.
     * @return Whether this AnimatorSet has been started and has not yet ended.
     */
    @Override
    public boolean isRunning() {
        for (Node node : mNodes) {
            if (node.animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

