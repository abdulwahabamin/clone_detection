    /**
     * Method that return a virtual identity composed by the name of the current process
     *
     * @return Identity The virtual identity
     */
    public static Identity createVirtualIdentity() {
        AID aid = AIDHelper.getAID(Process.myUid());
        if (aid == null) return null;
        return new Identity(
                new User(aid.getId(), aid.getName()),
                new Group(aid.getId(), aid.getName()),
                new ArrayList<Group>());
    }

