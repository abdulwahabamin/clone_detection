    @Override
    public String[] getColumnNames() {
        String[] originalColumnNames = super.getColumnNames();
        String[] ret = new String[originalColumnNames.length+1];
        System.arraycopy(originalColumnNames, 0, ret, 0, originalColumnNames.length);
        ret[ret.length-1] = BaseColumns._COUNT;
        return ret;
    }

