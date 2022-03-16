    void loadFiles(){
        fileDirectories.clear();
        for(String s : fileEx.listFiles()){
            if(fileEx.isFile(s))
                fileDirectories.add(new FileDirectory(s,FileDirectory.FILE
                        , fileEx.getFileSize(s),fileEx.getInfo(s),fileEx.getFilePath(s)));
            else
                fileDirectories.add(new FileDirectory(s,FileDirectory.DIR
                        , fileEx.getFileSize(s),fileEx.getInfo(s),fileEx.getFilePath(s)));
        }

    }

