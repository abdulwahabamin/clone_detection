    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        sortItem=menu.findItem(R.id.action_sort);
        return super.onCreateOptionsMenu(menu);
    }

