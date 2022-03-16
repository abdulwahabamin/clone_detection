    public void setCrumbList(String path){
        crumbList.clear();
        completePath.delete(0,completePath.length());
        completePath.append(path);
        recyclerView.scrollToPosition(crumbList.size());
        getCrumbList(path);
        notifyDataSetChanged();
    }

