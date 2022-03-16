    public void backOnClick(View view){
        try {
            path = path.getParentFile();
            if(path!= null){
                LoadFiles(path);
                adapter.notifyDataSetChanged();
            }
        }catch (Exception ex){

        }
    }

