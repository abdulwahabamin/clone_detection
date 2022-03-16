    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist){

        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

