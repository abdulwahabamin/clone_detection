        @Override
        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
                return node;
            } catch (CloneNotSupportedException e) {
               throw new AssertionError();
            }
        }

