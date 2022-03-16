    public List<FileDirectory> loadDirectories() {
        fileDirectoryList.clear();
        for (String name : fileEx.listFiles()) {
            if (fileEx.isFile(name)) {
                fileDirectoryList.add(new FileDirectory(name,
                        FileDirectory.FILE, fileEx.getFileSize(name),
                        fileEx.getAbsoluteInfo(fileEx.getFilePath(name)),
                        fileEx.getFilePath(name)));
            } else {
                fileDirectoryList.add(new FileDirectory(name,
                        FileDirectory.DIR, fileEx.getFileSize(name),
                        fileEx.getAbsoluteInfo(fileEx.getFilePath(name))
                        , fileEx.getFilePath(name)));
            }
        }
        return fileDirectoryList;
    }

