    public boolean deleteFile(int position) {
        try {
            File f = mFileList.get(position);

            if (deleteFile(f)) {
                mFileList.remove(position);
                notifyItemRemoved(position);
                return true;
            } else {
                return false;
            }
        } catch (SecurityException se) {
            return false;
        }
    }

