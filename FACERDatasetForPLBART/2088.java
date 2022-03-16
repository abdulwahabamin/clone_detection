    private List<File> fileModelLoad(File path, Context context) {
        List<File> filesList = new ArrayList<>();
        List<File> pathsList = new ArrayList<>();
        List<File> listFiles;
        FileOperation fileOperation = new FileOperation();
        listFiles = fileOperation.listFiles(path, context);
        for (File pathToFile : listFiles) {
            File file = new File(pathToFile.getAbsolutePath());
            if (file.canRead() && file.exists()) {
                if (file.isFile()) {
                    filesList.add(file);
                } else {
                    pathsList.add(file);
                }
            }
        }
        Collections.sort(pathsList, (lhs, rhs) ->
                lhs.getName().toUpperCase().compareTo(rhs.getName().toUpperCase()));
        Collections.sort(filesList, (lhs, rhs) -> lhs.getName().compareTo(rhs.getName()));
        List<File> fileModelList = new ArrayList<>(pathsList);
        fileModelList.addAll(filesList);
        return fileModelList;
    }

