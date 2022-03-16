    void setQuickAccessList(){
        quickAccessList.add(IMAGES);
        quickAccessList.add(AUDIO);
        quickAccessList.add(VIDEO);
        quickAccessList.add(DOCUMENTS);
        quickAccessAdapter=new QuickAccessAdapter(quickAccessList);
        quickAccess.setAdapter(quickAccessAdapter);
        Intent i=new Intent(this,QuickAccess.class);
        quickAccessAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                int selection=0;
                switch (quickAccessList.get(position)){
                    case IMAGES:
                        selection= QuickAccess.IMAGES;
                        break;

                    case AUDIO:
                        selection=QuickAccess.AUDIO;
                        break;

                    case VIDEO:
                        selection=QuickAccess.VIDEO;
                        break;

                    case DOCUMENTS:
                        selection=QuickAccess.DOCUMENTS;
                        break;

                    default:
                        selection=QuickAccess.IMAGES;
                }

                i.putExtra("select_data",selection);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        });

    }

