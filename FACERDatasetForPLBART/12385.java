    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.mExecute ? 1231 : 1237);
        result = prime * result + (this.mRead ? 1231 : 1237);
        result = prime * result + (this.mWrite ? 1231 : 1237);
        return result;
    }

