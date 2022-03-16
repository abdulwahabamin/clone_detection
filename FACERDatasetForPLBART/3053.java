    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager AM = this.getAssets();
        try {
            InputStream IS = AM.open("directory.png");
            directoryPic = BitmapFactory.decodeStream(IS);
            IS = AM.open("file.png");
            filePic = BitmapFactory.decodeStream(IS);
            IS = AM.open("txtfile.png");
            txtFilePic = BitmapFactory.decodeStream(IS);
        } catch (IOException ioe) {
            Log.println(Log.ERROR, "error", ioe.getMessage());
        }

        gridView = this.findViewById(R.id.grid_view);
        gridView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                FileView selected = adapter.getItem(i);
                path = selected.file;
                if(path.isDirectory()){
                    LoadFiles(path);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });

        AlertDialog.Builder builder = new	AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("Create directory");
        LayoutInflater inflater	= this.getLayoutInflater();
        final View view	= inflater.inflate(R.layout.create_dir_layout,null,false);
        builder.setView(view);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                EditText editText = view.findViewById(R.id.edit_create_dir);
                File f = new File(path.getPath()+"//"+editText.getText());
                f.mkdir();
                adapter.add(new FileView(f, directoryPic));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogCreate = builder.create();

        builder = new	AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setTitle("Rename file");
        LayoutInflater inflater1	= this.getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.create_dir_layout,null,false);
        builder.setView(view);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                EditText editText = view.findViewById(R.id.edit_create_dir);
                File f = adapter.getItem(curItem).file;
                File newfile = new File(path, editText.getText().toString());
                f.renameTo(newfile);
                LoadFiles(path);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogRename = builder.create();



        builder = new	AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
        builder.setMessage("Are you sure?");
        builder.setTitle("Warning");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                Delete(adapter.getItem(curItem).file);
                LoadFiles(path);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
       dialogYesNo = builder.create();
       //dialog.show();

        esMainDir = null;
        if	(this.isExternalStorageWritable())  {
            esMainDir = Environment.getExternalStorageDirectory();
        }

        listFiles = new ArrayList<>();
        if(esMainDir!= null){
            LoadFiles(esMainDir);
        }  else  {
            Toast.makeText(this,"Directory is empty!",	Toast.LENGTH_SHORT).show();
        }

        adapter = new FileAdapter(this, R.layout.file_layout, listFiles);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (MainActivity.this.curItem != -1) {
                    MainActivity.this.curView.setBackgroundColor(Color.parseColor("#EEEEEE"));
                }
                MainActivity.this.curItem = position;
                MainActivity.this.curView = view;
                MainActivity.this.curView.setBackgroundColor(Color.parseColor("#aEEEaE"));
            }
        });
    }

