    private void initWidgets(){
        Button button_back=(Button)findViewById(R.id.backbutton_citymanagement_activity);
        button_edit_city=(Button)findViewById(R.id.editbutton_citymanagement_activity);
        Button button_add_city=(Button)findViewById(R.id.addbutton_citymanagement_activity);
        RecyclerView mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_citymanagement_activity);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialize button_back button.
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        mAdapter=new RecyclerAdapter(mListData);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnMyItemClickListener(new RecyclerAdapter.OnMyItemClickListener() {
            @Override
            public void onDeleteButtonClick(View view, int position) {
                if(mListData.size()>1){
                    mListData.remove(position);
                    mAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(CityManagementActivity.this,"至少需�?�?留一个城市",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onListItemClick(View view) {
                if(button_edit_stateflag) {
                    mAdapter.isEditting=false;
                    mAdapter.notifyDataSetChanged();
                    button_edit_city.setBackgroundResource(R.drawable.ic_action_edit);
                    saveSelectedCounty();
                    button_edit_stateflag = false;
                }
            }

            @Override
            public void onListItemLongClick(View view) {
                mAdapter.isEditting=true;
                mAdapter.notifyDataSetChanged();
                button_edit_city.setBackgroundResource(R.drawable.ic_action_accept);
                button_edit_stateflag=true;
            }
        });

        //initialize button_edit_city button
        button_edit_stateflag=false;
        button_edit_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!button_edit_stateflag){
                    mAdapter.isEditting=true;
                    mAdapter.notifyDataSetChanged();
                    v.setBackgroundResource(R.drawable.ic_action_accept);
                    button_edit_stateflag=true;
                }else{
                    mAdapter.isEditting=false;
                    mAdapter.notifyDataSetChanged();
                    v.setBackgroundResource(R.drawable.ic_action_edit);
                    saveSelectedCounty();
                    button_edit_stateflag=false;
                }
            }
        });

        //initialize  button_add_city button
        button_add_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CityManagementActivity.this,ChooseCityActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

