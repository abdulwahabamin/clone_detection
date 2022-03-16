    private void deleteCacheFile() {
        File dir = MyApplication.getAppContext().getExternalFilesDir(null);
        File[] children = dir.listFiles();
        for (int i = 0; i < children.length; i++) {
//            LogUtils.e("children", children[i]);
//            File tmp = new File(children[i]);
            if (children[i].exists() && children[i].isFile()) {
                Logger.d("exist", "文件存在");
                if (children[i].delete()) {
                    Logger.d("delete", "删除�?功");
                }
            } else {
                Logger.d("no exist", "文件�?存在");
            }


        }
    }

