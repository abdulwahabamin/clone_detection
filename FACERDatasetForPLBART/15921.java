                @Override
                public void run() {
                    for(GroupConnectionListener listener : groupConnectionListenerList) {
                        listener.onConnectionFailed("Username already taken");
                    }
                }

