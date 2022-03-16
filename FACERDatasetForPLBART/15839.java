        void createGroup(final String username, final String groupName,
                         final GroupCreationListener groupCreationListener,
                         final GroupMemberListener groupMemberListener,
                         final RequestListener requestListener) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.createGroup(username, groupName, groupCreationListener,
                            groupMemberListener, requestListener);
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

