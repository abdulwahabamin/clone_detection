        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case 1:
                 bar.setSubtitle("Connected to:"+msg.obj.toString());
                    break;
                case 2:
                    al.add(msg.obj.toString());
                    arr.notifyDataSetChanged();
                    break;
            }
        }

