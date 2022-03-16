        private void doRename(){
            showToast("é‡?å‘½å??"+position);
            RenameFileDialog dialog=new RenameFileDialog(context,filedata,position);
            dialog.setOnFileRenameListener(new RenameFileDialog.OnFileRenameListener() {
                @Override
                public void onFileRenamed(boolean success) {
                    String message=null;
                    if(filedata.get(position).isFile()){
                        message="æ–‡ä»¶";
                    }else{
                        message="æ–‡ä»¶å¤¹";
                    }
                    if(success){
                        message+="é‡?å‘½å??æˆ?åŠŸ";
                    }else{
                        message+="é‡?å‘½å??å¤±è´¥";
                    }
                    showToast(message);
                }
            });
            dialog.show();
            setfiledata(filedata);
        }

