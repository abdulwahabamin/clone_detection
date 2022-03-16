    /**
     * Attempts to visit the app's page in the Play Store via the Play Store app. If this fails
     * (the Play Store app not installed on the user's device), the second try is to do so via
     * the browser.
     */
    private void goToPlayStore() {
        final String appPackageName = getPackageName();
        try {
            startActivityWithTransitionAnimation(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            startActivityWithTransitionAnimation(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id="
                            + appPackageName)));
        }
    }

