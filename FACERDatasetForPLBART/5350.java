    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        headImage=findViewById(R.id.image);
        int name=intent.getExtras().getInt("select_data");
        switch (name){

            case QuickAccess.IMAGES:
                collapsingToolbarLayout.setTitle("Images");
                headImage.setImageResource(R.drawable.picture);
                break;

            case AUDIO:
                collapsingToolbarLayout.setTitle("Music");
                headImage.setImageResource(R.drawable.music);
                break;

            case VIDEO:
                collapsingToolbarLayout.setTitle("Videos");
                headImage.setImageResource(R.drawable.video);
                break;

            case DOCUMENTS:
                collapsingToolbarLayout.setTitle("Documents");
                headImage.setImageResource(R.drawable.file);
                break;


        }
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
        collapsingToolbarLayout.setExpandedTitleMargin(20,20,0,20);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedQuick);
        collapsingToolbarLayout.setExpandedTitleTypeface(AppController.getTypeface());
        handleIntent(intent);
    }

