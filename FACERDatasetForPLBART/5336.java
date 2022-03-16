    @Override
    public void onClick(View view, int position) {
        intent=new Intent(this,Browse.class);
        fileEx.changeRootDirectory(storageList.get(position).getPath());
        fileEx.setCurrentDir(storageList.get(position).getPath());
        intent.putExtra(getResources().getString(R.string.dir_reference),
                storageList.get(position).getPath());
        startActivity(intent);
    }

