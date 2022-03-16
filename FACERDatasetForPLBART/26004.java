    private static File createFile(String path, String fileName) {
        StringBuilder sb = new StringBuilder();
        if (path.endsWith(File.separator)) {
            sb.append(path).append(fileName);
        }else{
            sb.append(path).append(File.separator).append(fileName);
        }
        return new File(sb.toString());
    }

