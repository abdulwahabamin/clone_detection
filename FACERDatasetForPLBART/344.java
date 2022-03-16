    public void insertMessage(String message_content,String author,String adresseMac){
        Date date=new Date();
        ContentValues values= new ContentValues();
        values.put(MESSAGE_TABLE_MSG_CONTENT,message_content);
        values.put(MESSAGE_TABLE_MSG_AUTHOR,author);
        values.put(MESSAGE_TABLE_MSG_DATE,date.toString());
        values.put(MESSAGE_TABLE_EXTERN_MAC,adresseMac);
        myDatabase.insert(MESSAGE_TABLE,null,values);
    }

