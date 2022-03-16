        private void doRename(){
            showToast("�?命�??"+position);
            RenameFileDialog dialog=new RenameFileDialog(context,filedata,position);
            dialog.setOnFileRenameListener(new RenameFileDialog.OnFileRenameListener() {
                @Override
                public void onFileRenamed(boolean success) {
                    String message=null;
                    if(filedata.get(position).isFile()){
                        message="文件";
                    }else{
                        message="文件夹";
                    }
                    if(success){
                        message+="�?命�??�?功";
                    }else{
                        message+="�?命�??失败";
                    }
                    showToast(message);
                }
            });
            dialog.show();
            setfiledata(filedata);
        }

