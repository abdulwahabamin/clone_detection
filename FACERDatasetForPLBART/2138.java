    private static long sizeOf(File file, AddToDatabaseCallback callback) {
        if (file.isDirectory()) {
            return Objects.requireNonNull(getDirectorySize(file, callback)).getSizeDirectory();
        } else {
            return file.length();
        }
    }

