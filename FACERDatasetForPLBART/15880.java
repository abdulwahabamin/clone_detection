        public String getMemberId(String memberName) {
            String memberId = null;
            for(String id : currentGroup.groupMembers.keySet()) {
                Member member = currentGroup.groupMembers.get(id);
                if(member.name.equals(memberName)) {
                    memberId = id;
                    break;
                }
            }

            return memberId;
        }

