    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_exchange);
        myFile = new MyFile();
        chooseButton = (Button)findViewById(R.id.choosefile);
        sendButton = (Button)findViewById(R.id.sendfile);
        showFile = (TextView)findViewById(R.id.showfile);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");

                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        myFile.setFileChangeListener(new MyFile.FileChangeListener() {
            @Override
            public void onChange() {
                showFile.setText(myFile.getFile().getPath());
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(uri==null) {
                    Toast.makeText(FileExchangeActivity.this, "Select any file first", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.setPackage("com.android.bluetooth");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(sharingIntent, "Share file"));
            }
        });



    }

