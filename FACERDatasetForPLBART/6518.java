    private RootInfo getRootLocked(String authority, String rootId) {
        for (RootInfo root : mRoots.get(authority)) {
            if (Objects.equal(root.rootId, rootId)) {
                return root;
            }
        }
        return null;
    }

