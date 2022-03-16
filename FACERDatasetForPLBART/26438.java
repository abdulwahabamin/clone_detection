    private static void workThreadInit(final Context context) {
        TaskScheduler.execute(new Runnable() {
            @Override
            public void run() {
                PlatformConfig.setWeixin("wxf56994fcbedb2d97", "ceedf892637bed9b8d431e9eb2cf075a");
                PlatformConfig.setQQZone("1105761457", "SdMWEVML7ct0szb1");
                UMShareAPI.get(context);
            }
        });
    }

