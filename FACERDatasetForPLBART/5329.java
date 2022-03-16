    void setRecentItemListener(){
        recentFilesAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i=fileEx.getAbsoluteOpenableIntent(recentFilesAdapter.getTotalList()
                        .get(position).getPath());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {
                Dialog menuDialog=new Dialog(Home.this);
                menuDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                menuDialog.getWindow().setBackgroundDrawableResource(R.drawable.curved_back);
                menuDialog.setContentView(R.layout.options_layout);
                TextView open=menuDialog.findViewById(R.id.open);
                TextView share=menuDialog.findViewById(R.id.share);
                open.setTypeface(AppController.getTypeface());
                share.setTypeface(AppController.getTypeface());
                open.setOnClickListener(view1 -> {
                    String parent_dir=new File(recentFilesAdapter.getTotalList().get(position)
                            .getPath()).getParent();
                    Intent i=new Intent(Home.this,Browse.class);
                  //  Log.e(TAG,"parent dir: "+parent_dir);
                    i.putExtra(getResources().getString(R.string.dir_reference),parent_dir);
                    menuDialog.dismiss();
                    startActivity(i);
                    //menuDialog.dismiss();
                });

                share.setOnClickListener(view1 -> {
                    String path=recentFilesAdapter.getTotalList().get(position).getPath();

                    ArrayList<Uri> uris=new ArrayList<>(1);
                    uris.add(Uri.fromFile(new File(path)));

                    final Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    intent.setType("*/*");
                    intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                    menuDialog.dismiss();
                    startActivity(Intent.createChooser(intent,"Send"));

                });
                menuDialog.show();
            }
        });
    }

