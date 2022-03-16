    @VisibleForTesting
    static List<RootInfo> getMatchingRoots(Collection<RootInfo> roots, State state) {
        final List<RootInfo> matching = Lists.newArrayList();
        for (RootInfo root : roots) {
            final boolean supportsCreate = (root.flags & Root.FLAG_SUPPORTS_CREATE) != 0;
            final boolean advanced = (root.flags & Root.FLAG_ADVANCED) != 0;
            final boolean localOnly = (root.flags & Root.FLAG_LOCAL_ONLY) != 0;
            final boolean empty = (root.flags & Root.FLAG_EMPTY) != 0;

            // Exclude read-only devices when creating
            if (state.action == State.ACTION_CREATE && !supportsCreate) continue;
            // Exclude advanced devices when not requested
            if (!state.showAdvanced && advanced) continue;
            // Exclude non-local devices when local only
            if (state.localOnly && !localOnly) continue;
            // Only show empty roots when creating
            if (state.action != State.ACTION_CREATE && empty) continue;

            // Only include roots that serve requested content
            final boolean overlap =
                    MimePredicate.mimeMatches(root.derivedMimeTypes, state.acceptMimes) ||
                    MimePredicate.mimeMatches(state.acceptMimes, root.derivedMimeTypes);
            if (!overlap) {
                continue;
            }

            matching.add(root);
        }
        return matching;
    }

