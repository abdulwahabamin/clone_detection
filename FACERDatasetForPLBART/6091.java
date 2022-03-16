    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        String aClass = getIntent().getStringExtra("class");
        switch (aClass) {
            case "image":
                transaction.add(R.id.show_detial, new ImageFragment());
                break;
            case "music":
                transaction.add(R.id.show_detial, new MusicFragment());
                break;
            case "video":
                transaction.add(R.id.show_detial, new VideoFragment());
                break;
            case "word":
                transaction.add(R.id.show_detial, new WordFragment());
                break;
            case "apk":
                transaction.add(R.id.show_detial, new ApkFragment());
                break;
            case "zip":
                transaction.add(R.id.show_detial, new ZipFragment());
                break;
            case "filename":
                transaction.add(R.id.show_detial,new FileNameFragment());
                break;
            case "filetype":
                transaction.add(R.id.show_detial,new FileTypeFragment());
                break;
        }
        transaction.commit();
    }

