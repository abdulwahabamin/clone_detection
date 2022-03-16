    /**
     * Return the number of animations currently running.
     *
     * Used by StrictMode internally to annotate violations.  Only
     * called on the main thread.
     *
     * @hide
     */
    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

