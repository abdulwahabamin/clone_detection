    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music= (ImageButton) findViewById(R.id.music);
        musicText= (TextView) findViewById(R.id.music_text);
        musicFilePaths=FileSort.getSpecificTypeOfFile(MainActivity.this,new String[]{".mp3",".wma"});
        musicText.setText("音�?"+"("+musicFilePaths.size()+")");
        videoText= (TextView) findViewById(R.id.video_text);
        videoFilePaths=FileSort.getSpecificTypeOfFile(MainActivity.this,new String[]{".mp4",".avi",".rmvb",".flash"});
        videoText.setText("视频"+"("+videoFilePaths.size()+")");
        pictureText= (TextView) findViewById(R.id.picture_text);
        pictureFilePaths=FileSort.getSpecificTypeOfFile(MainActivity.this,new String[]{".gif",".jpeg",".bmp",".jpg"});
        pictureText.setText("图片"+"("+pictureFilePaths.size()+")");

        Log.d("Main", "onCreate: start initalize");
        intiMessage();
        Log.d("Main", "onCreate: finish initalize");
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter messageAdapter=new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        leftmenu_file=findViewById(R.id.leftmenu_file);
        Log.d("MainActivity", "onCreate: success compelete main");
        leftmenu_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "onClick: success receive");
                try{
                    Intent intent=new Intent(MainActivity.this,FileListActivity.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"进入activity异常",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

