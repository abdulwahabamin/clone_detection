        public Member getMemberFromUsername(String username) {
            for(Member member : groupMembers.values()) {
                if(member.name.equals(username)) {
                    return member;
                }
            }
            return null;
        }

