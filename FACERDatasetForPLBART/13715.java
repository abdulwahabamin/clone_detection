    public void performFileDeletion(FileModel fileModel) {
        File file = new File(fileModel.getParentDirectoryPath(), fileModel.getName());
        if (file.exists()) {
            if (FileUtil.getInstance().deleteFileOrDir(file)) {
                fetchCurrentStorageDirectory(fileModel.getParentDirectoryPath());
            } else {
                view.onError("File could not be deleted");
            }
        } else {
            view.onError("File not found");
        }
    }

