    private void initView(){
        rootPath= Environment.getExternalStorageDirectory().toString();
        nowPathStack=new Stack<>();
        lv= (ListView) findViewById(R.id.file_list);
        filePath= (TextView) findViewById(R.id.filePath);
        files=Environment.getExternalStorageDirectory().listFiles();
        nowPathStack.push(rootPath);
        for(File f:files){
            data.add(f);
        }
        filePath.setText(getPathString());
        fileAdapter=new FileAdapter(this,data);
        fileAdapter.setOnCopyListener(this);
        lv.setAdapter(fileAdapter);
        lv.setOnItemClickListener(new FileItemClickListener());
    }

