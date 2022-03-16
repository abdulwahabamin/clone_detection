    public static ArrayList<File> loadPath(File path, Context context) {
        if (!path.isDirectory()) {
            return null;
        }
        FileOperation fileOperation = new FileOperation();
        return new ArrayList<>(fileOperation.fileModelLoad(path, context));
    }

