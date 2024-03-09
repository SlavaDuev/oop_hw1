// Реализация класса ГорячийНапиток
class ГорячийНапиток {
    protected String name;
    protected int volume;
    
    public ГорячийНапиток(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    
    public void выпить() {
        System.out.println("Выпито " + volume + " мл " + name);
    }
}

// Создание наследника реализованного класса ГорячийНапиток
class ГорячийНапитокСТемпературой extends ГорячийНапиток {
    private int температура;
    
    public ГорячийНапитокСТемпературой(String name, int volume, int температура) {
        super(name, volume);
        this.температура = температура;
    }
    
    public void установитьТемпературу(int температура) {
        this.температура = температура;
        System.out.println(name + " теперь имеет температуру " + температура + "°C");
    }
    
    public int getТемпература() {
        return температура;
    }
}

// Интерфейс ТорговыйАвтомат
interface ТорговыйАвтомат {
    public void getProduct(String name, int volume, int температура);
}

// Реализация класса ГорячихНапитковАвтомат, реализующего интерфейс ТорговыйАвтомат
class ГорячихНапитковАвтомат implements ТорговыйАвтомат {
    public void getProduct(String name, int volume, int температура) {
        ГорячийНапитокСТемпературой напиток = new ГорячийНапитокСТемпературой(name, volume, температура);
        System.out.println("Получен напиток " + напиток.name + " (" + напиток.volume + " мл, " + напиток.getТемпература() + "°C)");
        напиток.выпить();
    }
}

public class Main {
    public static void main(String[] args) {
        ГорячихНапитковАвтомат автомат = new ГорячихНапитковАвтомат();
        
        автомат.getProduct("Чай", 200, 70);
        автомат.getProduct("Кофе", 150, 85);
        
        ГорячийНапитокСТемпературой горячийШоколад = new ГорячийНапитокСТемпературой("Горячий шоколад", 250, 90);
        горячийШоколад.установитьТемпературу(85);
        горячийШоколад.выпить();
    }
}
