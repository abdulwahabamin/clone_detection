    private static void updateDialog(final Activity activity, final UpdateInfo updateInfo) {
        String message = String.format("v %1$s(%2$sMB)\n\n%3$s", updateInfo.versionShort,
                b2mb(updateInfo.binary.fsize), updateInfo.changelog);
        new AlertDialog.Builder(activity)
                .setTitle("�?�现新版本")
                .setMessage(message)
                .setPositiveButton("立�?�更新", (dialog, which) -> download(activity, updateInfo))
                .setNegativeButton("�?�?��??醒", null)
                .show();
    }

