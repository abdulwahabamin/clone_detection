    private void deleteMultiFile() {
//        int toast = 0;
        LinkedList<File> files = new LinkedList<File>();
        for (IconifiedText it : mDirectoryEntries) {
            if (!it.isSelected()) {
                continue;
            }

            File file = FileUtils.getFile(currentDirectory, it.getText());
            files.add(file);
//            if (file.isDirectory()) {
//                if (!recursiveDelete(file, true)) {
//                    break;
//                }
//            } else {
//                if (!file.delete()) {
//                    toast = R.string.error_deleting_file;
//                    break;
//                }
//            }
        }

        new RecursiveDeleteTask().execute(files);
        
//        if (toast == 0) {
//            // Delete was successful.
//            refreshList();
//            toast = R.string.file_deleted;
//        }
//
//        Toast.makeText(FileManagerActivity.this, toast, Toast.LENGTH_SHORT).show();
    }

