    private void compressMultiFile(String out) {
        List<File> files = new ArrayList<File>();
        for (IconifiedText it : mDirectoryEntries) {
            if (!it.isSelected()) {
                continue;
            }

            File file = FileUtils.getFile(currentDirectory, it.getText());
            files.add(file);
        }
        new CompressManager(FileManagerActivity.this).compress(files, out);
    }

