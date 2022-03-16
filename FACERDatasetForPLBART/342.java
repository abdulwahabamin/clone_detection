    public Cursor getAllMessageForMAc(String adresseMac){

        String query = "SELECT * FROM "+MESSAGE_TABLE+" WHERE "+MESSAGE_TABLE_EXTERN_MAC+"='"+adresseMac+"'";
        return myDatabase.rawQuery(query, null);

    }

