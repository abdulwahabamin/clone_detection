    Intent openFile(String path){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(path));

        String type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap
                .getFileExtensionFromUrl(uri.toString()));
        intent.setDataAndType(uri, type);
        if (intent.resolveActivity(getPackageManager()) == null)
            return null;
        return intent;
    }

