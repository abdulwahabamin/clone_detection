    @Override
    public void retrievePlaylistHashMapFromFile(){
        try{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this, "Permission Denied to access internal files!", Toast.LENGTH_LONG).show();
                    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

                    requestPermissions(permissions, 1);
                }else{
                    File playlistFile = new File(Environment.getExternalStorageDirectory(), "playlist_file.txt");
                    FileInputStream inputStream = new FileInputStream(playlistFile);
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                    playlistMap = (HashMap<String, ArrayList<File>>) objectInputStream.readObject();

                    inputStream.close();
                    objectInputStream.close();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

