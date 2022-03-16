    public void show() {
        if (dialog == null) {
            return;
        }
        dialog.show();
        dialog.getWindow().setContentView(R.layout.dialog_rename_file);
        btnRename = (Button) dialog.getWindow().findViewById(R.id.btn_dlg_rename_confirm);
        btnCancel = (Button) dialog.getWindow().findViewById(R.id.btn_dlg_rename_cancle);
        etFileName = (EditText) dialog.getWindow().findViewById(R.id.et_dlg_rename);
        tvFileType = (TextView) dialog.getWindow().findViewById(R.id.tv_dlg_file_type);
        if (webFiles.get(position).isFile()) {
            tvFileType.setText("." +getTailName(webFiles.get(position).getName()));
        }else{
            tvFileType.setText("");
        }
        btnRename.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dialog.dismiss();;
                if(onFileRenameListener!=null){
                    onFileRenameListener.onFileRenamed(renameFile());
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

