    /**
     * This method is used to forward the call to the protected reset() method
     * We create this class in the same package rx.plugins so we can access the
     * protected method
     */
    public static void resetPlugins() {

        getInstance().reset();
    }

