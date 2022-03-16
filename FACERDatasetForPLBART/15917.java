    @Override //always called on a client-handling specific thread. Don't try to prevent blocking.
    public void onNewMemberJoined(final String memberId, String memberName) {

        final ResponseListener usernameResponse = new ResponseListener() {
            @Override
            public void onResponseReceived(Object responseData) {
                final String newMemberUsername = (String) responseData;

                //check if username taken
                if(userName.equals(newMemberUsername)
                        || currentGroup.getMemberFromUsername(newMemberUsername) != null) {
                    //check if this is group owner

                    if(isOwner) {
                        netService.sendRequest(memberId, ACTION_NOTIFY_USERNAME_TAKEN, null, null);
                    }
                } else {

                    currentGroup.addMember(memberId, newMemberUsername);

                    ResponseListener getLibrary = new ResponseListener() {
                        @Override
                        public void onResponseReceived(Object responseData) {
                            exchangeLibraries(memberId, (Socket) responseData, true);

                            updateLibraryLists(memberId);
                        }

                        @Override
                        public void onRequestFailed() {
                            currentGroup.removeMember(memberId);
                        }
                    };

                    //exchange libraries
                    netService.getRawSocket(memberId, getLibrary);
                }
            }
            @Override
            public void onRequestFailed() {}
        };

        netService.sendRequest(memberId, ACTION_GET_USERNAME, userName, usernameResponse);
    }

