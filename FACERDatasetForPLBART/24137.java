    @Override
    public int getColumnIndexOrThrow(String columnName) {
        if (columnName.equals(BaseColumns._COUNT))
            return super.getColumnCount();
        else
            return super.getColumnIndexOrThrow(columnName);
    }

