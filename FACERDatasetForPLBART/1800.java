    private void loadMore() {
        Utils.log("load more called");
        chat_db = RealmManager.getRealm().where(Message.class).equalTo("id", user.message_id).findAllSorted("timestamp", Sort.DESCENDING);
        total_msg_count =chat_db.size();

        if (chat_db==null)
        {
            return;
        }
        if (total_msg_count >= current_msg_count) {
            current_msg_count =  current_msg_count+20;
            current_msg_count=  (current_msg_count<total_msg_count)?current_msg_count:total_msg_count;
            list.addAll(chat_db.subList(list.size(),current_msg_count));
            pagination_done=true;
            rv.post(new Runnable() {
                @Override
                public void run() {
                    cAdapter.notifyDataSetChanged();
                }
            });
        }
    }

