    @Override
    public void savePlaylistHashMap(HashMap<String, ArrayList<File>> map){
        try{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "Permission Denied to access internal files!", Toast.LENGTH_LONG).show();
                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                    requestPermissions(permissions, 1);
                }else{
                    File playlistFile = new File(Environment.getExternalStorageDirectory(), "playlist_file.txt");

                    if(!playlistFile.exists()){
                        playlistFile.createNewFile();
                    }

                    FileOutputStream fileOutputStream = new FileOutputStream(playlistFile);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    objectOutputStream.writeObject(map);

                    fileOutputStream.close();
                    objectOutputStream.close();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

