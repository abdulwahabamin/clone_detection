    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intn=new Intent(MainPage.this,ChatActivity.class);
        intn.putExtra("isClient",false);
        startActivity(intn);
        return true;
    }

