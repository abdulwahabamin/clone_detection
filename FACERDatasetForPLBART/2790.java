    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_extsdcard, container, false);
       /* final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        String ext="storage/";
        File me_file = new File(ext);

        String extname="";
        for(File fi:me_file.listFiles()){
            if(!fi.getName().equals("self") && !fi.getName().equals("emulated")) {
                extname = "/storage/"+fi.getName();
                break;
            }
        }

        m_root =extname;
                //Environment.getExternalStorageDirectory().getPath();
        ListView lvobj=(ListView)root.findViewById(R.id.ext_rl_lvListRoot);



        mAdView = root.findViewById(R.id.int_adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("A03E8CB1F034A0790951F2713CE1E0CE").build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        getDirFromRoot(m_root,lvobj);

        return root;
    }

