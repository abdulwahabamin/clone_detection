    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intn=new Intent(MainPage.this,ChatActivity.class);
        intn.putExtra("isClient",true);
        intn.putExtra("server",al3.get(position));
        startActivity(intn);
    }

