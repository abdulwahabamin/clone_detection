    public static void deleteFileRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteFileRecursive(child);
        boolean status=fileOrDirectory.delete();
        Utils.log(fileOrDirectory.getName()+" "+status);
    }

