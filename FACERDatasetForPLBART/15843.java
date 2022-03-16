        public void connectToGroup(final String groupId,
                                   final GroupConnectionListener groupConnectionListener,
                                   final GroupMemberListener groupMemberListener,
                                   final RequestListener requestListener) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.connectToGroup(groupId, groupConnectionListener, groupMemberListener,
                            requestListener);
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

