    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == super.getColumnCount())
            return BaseColumns._COUNT;
        else
            return super.getColumnName(columnIndex);
    }

