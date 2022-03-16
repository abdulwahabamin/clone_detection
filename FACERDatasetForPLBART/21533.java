    @Override
    public String getTextToShowInBubble(int pos) {
        if (mBusy || mFileSet.size() == 0)
            return "";
        try {
            File f = mFileSet.get(pos);
            if (f.isDirectory()) {
                return String.valueOf(f.getName().charAt(0));
            } else {
                return Character.toString(f.getName().charAt(0));
            }
        } catch (Exception e) {
            return "";
        }
    }

