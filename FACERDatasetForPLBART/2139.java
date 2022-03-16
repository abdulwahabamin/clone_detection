    public static String getFileType(File file) {
        if (file.isDirectory()) {
            return null;
        }
        String type = null;
        final String extension = getExtension(file.getName());
        if (!extension.isEmpty()) {
            final String extensionLowerCase = extension.toLowerCase(Locale.getDefault());
            final MimeTypeMap mime = MimeTypeMap.getSingleton();
            type = mime.getMimeTypeFromExtension(extensionLowerCase);
        }
        if (type == null) {
            type = "*/*";
        }
        return type;
    }

