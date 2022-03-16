    List<FileDirectory> getFileList(List<String> fileList){

        fileDirectoryList.clear();
        for(String s : fileEx.listFiles()){
            if(fileEx.isFile(s))
                fileDirectoryList.add(new FileDirectory(s,FileDirectory.FILE
                        , fileEx.getFileSize(s),fileEx.getInfo(s),fileEx.getFilePath(s)));
            else
                fileDirectoryList.add(new FileDirectory(s,FileDirectory.DIR
                        , fileEx.getFileSize(s),fileEx.getInfo(s),fileEx.getFilePath(s)));
        }
        return fileDirectoryList;
    }

