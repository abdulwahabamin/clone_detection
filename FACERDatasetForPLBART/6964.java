    private boolean renameFile() {
        String dirName = etFileName.getText().toString();
        if (dirName.equals("")) {
            AlertUtil.toastMess(context, "文件�??�?能为空");
            return false;
        } else {
            if (checkSameName(dirName)) {
                AlertUtil.toastMess(context, "文件�??已存在");
                return false;
            }
        }
        File file = webFiles.get(position);
        return file.renameTo(new File(file.getParentFile().getAbsolutePath() + "/" + dirName));
    }

