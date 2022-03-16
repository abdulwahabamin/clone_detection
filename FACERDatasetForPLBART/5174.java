    public BreadCrumbsAdapter(String path,RecyclerView recyclerView){
        getCrumbList(path);
        completePath.append(path);
        notifyDataSetChanged();
        this.recyclerView=recyclerView;
    }

