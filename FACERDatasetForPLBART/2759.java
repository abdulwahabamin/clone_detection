    @Override
    public boolean onContextItemSelected(MenuItem option) {
        String path;

        File f = (File) fileAdapter.getItem((int) lView.getTag());
        try {
            path = f.getCanonicalPath();
            switch (option.getItemId()) {
                case 0: // open
                    openFile(f);
                    break;
                case 1: // cut
                    clipboard.clear();
                    clipboard.add(path);
                    clipboard.operation = FileOp.CUT;
                    invalidateOptionsMenu();
                    break;
                case 2: // copy
                    clipboard.clear();
                    clipboard.add(path);
                    clipboard.operation = FileOp.COPY;
                    invalidateOptionsMenu();
                    break;
                case 3: // delete
                    startIOService(path, FileOp.DELETE);
                    Toast.makeText(this, "Deleting...", Toast.LENGTH_SHORT).show();
                    refresh();
                    break;
                case 4: // rename
                    renameFile(path);
                    refresh();
                    break;
                case 5: // properties
                    showProperties(path);
                    break;
                default:
            }
        } catch (IOException e) {
            Toast.makeText(this, "Failed to open file/folder", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return true;
    }

