    private void exchangeLibraries(final String memberId, Socket socket, boolean sendFirst) {
        final String newMemberUsername = currentGroup.groupMembers.get(memberId).name;

        try {
            if(sendFirst) {
                Library.sendOverStream(socket.getOutputStream());
                Library.getFromStream(socket.getInputStream(), newMemberUsername);
            } else {
                Library.getFromStream(socket.getInputStream(), newMemberUsername);
                Library.sendOverStream(socket.getOutputStream());
            }

            socket.close();

            currentGroup.addMember(memberId, newMemberUsername);
        } catch (IOException | JSONException e) {
            Log.d("exchange libs", e.toString());
        }
    }

