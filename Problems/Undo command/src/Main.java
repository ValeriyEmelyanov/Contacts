interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;

    @Override
    public void execute() {
        int len = entity.getInventoryLength();
        for (int i = 0; i < len; i++) {
            if (entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);
                return;
            }
        }
    }

    @Override
    public void undo() {
        int len = entity.getInventoryLength();
        for (int i = len - 1; i >= 0; i--) {
            String inventoryItem = entity.getInventoryItem(i);
            if (inventoryItem != null && inventoryItem.equals(item)) {
                entity.setInventoryItem(i, null);
                return;
            }
        }
    }
}