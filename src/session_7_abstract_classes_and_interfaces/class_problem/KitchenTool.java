abstract class KitchenTool {
    protected String name;
    protected String material;

    public KitchenTool(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public abstract void useTool();

    public void clean() {
        System.out.println("Cleaning " + name + " made of " + material);
    }
}

class ChefKnife extends KitchenTool {
    public ChefKnife() {
        super("Chef Knife", "Stainless Steel");
    }

    @Override
    public void useTool() {
        System.out.println("Chopping vegetables and slicing ingredients with precision.");
    }
}

class Blender extends KitchenTool {
    public Blender() {
        super("High-Speed Blender", "Tempered Glass & Steel");
    }

    @Override
    public void useTool() {
        System.out.println("Pureeing and blending ingredients into smoothies.");
    }
}
