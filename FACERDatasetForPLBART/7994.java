    public boolean renameFile(int position, String newName) {
        File newFile = new File(newName);

        if (mFileList.get(position).renameTo(newFile)) {
            mFileList.set(position, newFile);
            notifyItemChanged(position);
            return true;
        }

        return false;
    }

