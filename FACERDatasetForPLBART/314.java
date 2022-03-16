    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode== Activity.RESULT_OK)
        {
            if(data!=null)
            {
                this.uri = data.getData();
                myFile.setFile(new File(uri.getPath()));
                Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

