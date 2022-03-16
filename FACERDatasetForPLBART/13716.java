    public void renameFile(FileModel fileModel, String newFileName) {
        String oldFileName = fileModel.getName();

        if (!oldFileName.equals(newFileName)) {
            File oldFile = new File(fileModel.getParentDirectoryPath(), oldFileName);
            File newFile = new File(fileModel.getParentDirectoryPath(), newFileName);

            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    fetchCurrentStorageDirectory(fileModel.getParentDirectoryPath());
                } else {
                    view.onError("Could not rename file");
                }
            } else {
                view.onError("File not found");
            }
        } else {
            view.onError("No changes made");
        }
    }

