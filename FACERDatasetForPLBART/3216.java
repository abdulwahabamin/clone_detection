    public List<File> getAllFiles(File path) {
        File[] allFiles = path.listFiles();
        List<File> directories = new ArrayList<>();
        List<File> files = new ArrayList<>();

        for (File file : allFiles) {
            if (file.isDirectory()) {
                directories.add(file);
            } else {
                files.add(file);
            }
        }
        Collections.sort(directories);
        Collections.sort(files);
        directories.addAll(files);
        return directories;
    }

