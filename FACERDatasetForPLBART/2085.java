    public static void openFile(final Context context, final File target) {
        final String fileType = TypeFiles.getFileType(target);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri contentUri = FileProvider.getUriForFile(context,
                BuildConfig.APPLICATION_ID + ".fileprovider", target);
        intent.setDataAndType(contentUri, fileType);
        if (fileType != null && !fileType.equals("*/*")) {
            intent.setDataAndType(contentUri, fileType);
            if (context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                Toast.makeText(context, R.string.cantopenfile, Toast.LENGTH_SHORT).show();
                return;
            }
            context.startActivity(intent);
        }
    }

