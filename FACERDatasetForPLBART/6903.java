    private void doCreateNewFolder(){
        mydialog = new AlertDialog.Builder(FileListActivity.this).create();
        mydialog.show();
        mydialog.getWindow().setContentView(R.layout.newfloder_dialog);
        mydialog.setView(new EditText(FileListActivity.this));
        //加入下�?�两�?�以�?��?��?�弹出输入法
        mydialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        mydialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        newfloder_name = (EditText) mydialog.getWindow().findViewById(R.id.newfloder_name);

        mydialog.getWindow()
                .findViewById(R.id.newfloder_cancle)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mydialog.dismiss();
                    }
                });
        mydialog.getWindow()
                .findViewById(R.id.newfloder_create)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name =  newfloder_name.getText().toString();
                        if (name != null) {
                            File folder = new File(getPathString() + "/" + name);
                            folder.mkdirs();
                            if (folder.exists()) {
                                Toast.makeText(FileListActivity.this,"文件："+name + " 创建�?功",Toast.LENGTH_SHORT).show();
                                showChanged(getPathString());
                                mydialog.dismiss();
                            }
                        }

                    }
                });
    }

