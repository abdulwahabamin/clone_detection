    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
    }   

