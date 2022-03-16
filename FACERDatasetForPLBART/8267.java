    private void recycle() {
        // Recycle the navigation views
        if (mNavigationViews != null) {
            int cc = this.mNavigationViews.length;
            for (int i = 0; i < cc; i++) {
                this.mNavigationViews[i].recycle();
            }
        }
        try {
            FileManagerApplication.destroyBackgroundConsole();
        } catch (Throwable ex) {
            /**NON BLOCK**/
        }
        try {
            ConsoleBuilder.destroyConsole();
        } catch (Throwable ex) {
            /**NON BLOCK**/
        }
    }

