    public static void checkUpdate(final Activity activity, final boolean silent) {
//        FIR.checkForUpdateInFIR(BuildConfig.FIR_KEY, new VersionCheckCallback() {
//            @Override
//            public void onStart() {
//                if (!silent) {
//                    SnackbarUtils.show(activity, "正在检查更新");
//                }
//            }
//
//            @Override
//            public void onSuccess(String versionJson) {
//                Log.i(TAG, versionJson);
//                if (activity.isFinishing()) {
//                    return;
//                }
//                Gson gson = new Gson();
//                UpdateInfo updateInfo;
//                try {
//                    updateInfo = gson.fromJson(versionJson, UpdateInfo.class);
//                } catch (JsonSyntaxException e) {
//                    e.printStackTrace();
//                    return;
//                }
//                int version = Integer.valueOf(updateInfo.version);
//                if (version > BuildConfig.VERSION_CODE) {
//                    updateDialog(activity, updateInfo);
//                } else if (!silent) {
//                    SnackbarUtils.show(activity, "已是最新版本");
//                }
//            }
//
//            @Override
//            public void onFail(Exception exception) {
//                Log.e(TAG, "check update fail", exception);
//            }
//
//            @Override
//            public void onFinish() {
//            }
//        });
    }

