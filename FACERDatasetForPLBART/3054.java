    private void LoadFiles(File file){
        listFiles.clear();
        Button button = findViewById(R.id.button_back);
        if(file.getPath().equals(esMainDir.getPath())){
            button.setEnabled(false);
        }else{
            button.setEnabled(true);
        }
        File[] arrFiles = file.listFiles();
        for (File f : arrFiles){
            if (f.isDirectory()) {
                listFiles.add(new FileView(f, directoryPic));
            } else if(getFileExtension(f).equals("txt")){
                listFiles.add(new FileView(f, txtFilePic));
            }else{
                listFiles.add(new FileView(f, filePic));
            }
        }
    }

