    public static List<File> getParentsFile(File file) {
        List<File> files = new ArrayList<>();
        files.add(file);
        while (file.getParent() != null) {
            file = new File(file.getParent());
            files.add(file);
        }
        Collections.reverse(files);
        return files;
    }

