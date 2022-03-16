    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + (int) (id ^ id >>> 32);
        return result;
    }

