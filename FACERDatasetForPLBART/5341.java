    private void setMediaAdapter(int selectData){
        mediaAdapter=new MediaAdapter(fileList,QuickAccess.this,selectData, Glide.with(QuickAccess.this));
        mediaAdapter.setOnItemSelectedListener(QuickAccess.this);
        mediaAdapter.setOnRecyclerItemClickListener(QuickAccess.this);
        mediaRV.setAdapter(mediaAdapter);
        progressBar.setVisibility(View.GONE);
    }

