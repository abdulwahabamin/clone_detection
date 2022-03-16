    /**
     * 获�?�目录下指定文件�??的文件包括�?目录
     * <p>大�?写忽略</p>
     *
     * @param dir      目录
     * @param fileName 文件�??
     * @return 文件链表
     */
    public static List<File> searchFileInDir(File dir, String fileName) {
        if (dir == null || !isDir(dir)) return null;
        List<File> list = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null && files.length != 0) {
            for (File file : files) {
//                (str.indexOf("ABC")!=-1
                if (file.getName().toUpperCase().contains(fileName.toUpperCase())) {
                    list.add(file);
                }
                if (file.isDirectory()) {
                    list.addAll(searchFileInDir(file, fileName));
                }
            }
        }
        return list;
    }

