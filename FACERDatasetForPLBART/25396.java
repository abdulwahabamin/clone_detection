    private void sendCommand(final String command) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                client.blockingConnect(CONNECTION_TIME_OUT_MS, TimeUnit.MILLISECONDS);
                NodeApi.GetConnectedNodesResult result =
                        Wearable.NodeApi.getConnectedNodes(client).await();
                List<Node> nodes = result.getNodes();
                for (Node node : nodes) {
                    Wearable.MessageApi.sendMessage(client, node.getId(), command, null);
                }
                client.disconnect();
            }
        }).start();
    }

