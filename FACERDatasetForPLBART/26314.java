    private void loadUpgradeInfo() {

        /***** 获�?��?�级信�?� *****/
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();

        if (upgradeInfo == null) {
            LogHelper.info("AboutActivity", "no new version %s","s");
            return;
        }

        if (upgradeInfo.versionCode > Version.getVersionCode(this)) {
            mNewVersion.setText("有新版本更新");
            mNewVersionTip.setVisibility(View.VISIBLE);
        }

    }

