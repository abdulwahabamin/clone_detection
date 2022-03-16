    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.mGroup == null) ? 0 : this.mGroup.hashCode());
        result = prime * result + ((this.mGroups == null) ? 0 : this.mGroups.hashCode());
        result = prime * result + ((this.mUser == null) ? 0 : this.mUser.hashCode());
        return result;
    }

