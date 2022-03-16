    private void Delete(File file){
        //adapter.remove(adapter.getItem(curItem));
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files.length < 1){
                file.delete();
            }
            for(File f:files){
                Delete(f);
                f.delete();
            }
        }
        file.delete();
    }

