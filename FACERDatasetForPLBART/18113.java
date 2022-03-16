    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Album> arrayListp=new ArrayList<>();
        for(Album album:list){
            String name=album.getSong().toLowerCase();
            if(name.contains(newText))
                arrayListp.add(album);
        }
        albumAdapter.setfilter(arrayListp);
        return true;    }

