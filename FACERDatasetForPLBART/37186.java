    private static void updateDialog(final Activity activity, final UpdateInfo updateInfo) {
        String message = String.format("v %1$s(%2$sMB)\n\n%3$s", updateInfo.versionShort,
                b2mb(updateInfo.binary.fsize), updateInfo.changelog);
        new AlertDialog.Builder(activity)
                .setTitle("å?‘çŽ°æ–°ç‰ˆæœ¬")
                .setMessage(message)
                .setPositiveButton("ç«‹å?³æ›´æ–°", (dialog, which) -> download(activity, updateInfo))
                .setNegativeButton("ç¨?å?Žæ??é†’", null)
                .show();
    }

