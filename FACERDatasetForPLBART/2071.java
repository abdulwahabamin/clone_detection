    public void replaceSizeOnTextView(FileModel fileModel) {
        for (int pos = 0; pos < fileModels.size(); pos++) {
            FileModel currentFileModel = fileModels.get(pos);
            if (currentFileModel.getFile() == fileModel.getFile()) {
                fileModels.set(pos, fileModel);
                notifyItemChanged(pos);
                return;
            }
        }
    }

