package BLL;

public class AnimalBLL {
    public static int getNextIdAnimal(){
        int nextID = Repositorio.getRepositorio().getNextIDAnimal();
        Repositorio.getRepositorio().setNextIDAnimal(++nextID);
        return nextID;
    }

    public static void criarAnimal(Animal animal){
        int nextID = getNextIdAnimal();
        animal.setnChip(nextID);
        Repositorio.getRepositorio().getAnimal().put(animal.getnChip(), animal);
        Repositorio.getRepositorio().serializar("animal.repo", Repositorio.getRepositorio().getAnimal());
    }

}
