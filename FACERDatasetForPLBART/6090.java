    @Override
    public void onCreate() {
        super.onCreate();
        //å?‹ç›Ÿç»Ÿè®¡
        MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.UMAnalyticsConfig(this, "9cefd91191d36d9023985dc24c860b39", "MoRen");
        MobclickAgent.startWithConfigure(config);
        MobclickAgent.openActivityDurationTrack(false);
    }

