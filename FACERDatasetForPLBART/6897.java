    private void showChanged(String path){
        filePath.setText(path);
        files=new File(path).listFiles();
        data.clear();
        for(File f:files){
            data.add(f);
        }
        files=fileAdapter.setfiledata(data);
    }

