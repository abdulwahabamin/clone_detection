    @Override
    public void buildObjectFromCursor(Cursor cursor) {

        String path = cursor.getString(0);
        this.duration = cursor.getString(1);
        this.artistName = cursor.getString(2);
        this.id = cursor.getInt(3);
        this.name = cursor.getString(4);
        this.size = cursor.getLong(5);
        File file = new File(path);
        this.uri = Uri.fromFile(file);
        this.createdDate = new Date(file.lastModified());

    }

