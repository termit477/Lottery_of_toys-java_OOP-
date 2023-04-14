package Object_toy;

public abstract class Toy {
    
    protected String name;
    protected int id;
    protected int lot;
    protected int weight;

    public Toy(int id, String name, int lot, int weight){
        this.id = id;
        this.name = name;
        this.lot = lot;
        this.weight = weight;
    }

    public String getInfoAboutTheRemainingToys(){
        return String.format("Количество оставшихся игрушек: 4d", lot);
    }

    public int getLot(){
        return lot;
    }
    public String getInfo(){
        return String.format("%3d | %10s | Частота выпадения: %3d ", id, name, weight);
    }

    public int getId(){
        return id;
    }

    public int getWeight(){
        return weight;
    }
}
