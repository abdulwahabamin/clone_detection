    /**
     * �?�步读�?�一个文件，根�?�类型返回
     */
    public static <T> T readFileContent(String fileId ,Class<T> ype) {
        String fileContent = readFileContent(fileId);
        return JsonHelper.fromJson(fileContent,ype);
    }

