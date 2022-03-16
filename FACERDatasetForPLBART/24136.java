    @Override
    public int getColumnIndex(String columnName) {
        if (columnName.equals(BaseColumns._COUNT))
            return super.getColumnCount();
        else
            return super.getColumnIndex(columnName);
    }

