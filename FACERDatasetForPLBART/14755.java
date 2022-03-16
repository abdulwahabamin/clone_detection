    @Override
    public ArrayList<File> loadAllSongs(){
        final int PERMISSION_REQUEST_CODE = 1;
        ArrayList<File> newSongList = new ArrayList<>();
        File filePath;
        File[] dirSongList;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                Toast.makeText(this, "Permission Denied to access internal files!", Toast.LENGTH_LONG).show();
                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);
            }else{
                filePath = new File(Environment.getExternalStorageDirectory() + "/Download");
                dirSongList = filePath.listFiles();

                for(File f : dirSongList){
                    if(f.getName().contains(".mp3")){
                        newSongList.add(f);
                    }
                }
            }
        }

        return newSongList;
    }

