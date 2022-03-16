    public void backPressed() {
        if (fileManagerCore.hasPreviousDir()) {
            fileManagerCore.setCurrentDirectory(fileManagerCore.getPreviousDirectory());
            fileLoader.onContentChanged();
        }
    }

