    private void loadUpgradeInfo() {

        /***** èŽ·å?–å?‡çº§ä¿¡æ?¯ *****/
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();

        if (upgradeInfo == null) {
            LogHelper.info("AboutActivity", "no new version %s","s");
            return;
        }

        if (upgradeInfo.versionCode > Version.getVersionCode(this)) {
            mNewVersion.setText("æœ‰æ–°ç‰ˆæœ¬æ›´æ–°");
            mNewVersionTip.setVisibility(View.VISIBLE);
        }

    }

