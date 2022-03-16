    private void doPaste(){
        File newFile=new File(getPathString()+"/"+watingCopyFile.getName());
        if(watingCopyFile.equals(null)){
            //Snackbar.make(findViewById(R.id.main_view), "当�?粘贴�?�为空，�?能粘贴", Snackbar.LENGTH_SHORT).show();
        }else{
            if(watingCopyFile.isFile()&&watingCopyFile.exists()){
                try {
                    FileInputStream fis = new FileInputStream(watingCopyFile);
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len = -1;
                    long contentSize = watingCopyFile.length();
                    long readed = 0;
                    byte[] buff = new byte[8192];
                    while ((len=fis.read(buff))!=-1){
                        //写文件
                        fos.write(buff,0,len);
                        readed+=len;
                        //�?�布进度
                    }
                    fos.flush();
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {

                }
            }
        }
        if (newFile.exists()) {
            Toast.makeText(FileListActivity.this,"�?制" + newFile.getName() + "�?功",Toast.LENGTH_SHORT).show();
            fileAdapter.notifyDataSetChanged();
        }
    }

