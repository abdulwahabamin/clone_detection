    @Override
    public void onBackPressed() {
        if (isTaskRoot())
        {
            startActivity(new Intent(this,MainActivity.class));
        }
        super.onBackPressed();
    }

