package checkpointOne;

import java.util.*;
public class Concessionaria {
    private String nome;
    private String address;

    List<Car> listaAutoInVendita;

    public Concessionaria(String nome, String address) {
        this.nome = nome;
        this.address = address;
        this.listaAutoInVendita = new ArrayList<>();
    }

    public Concessionaria(String nome, String address, List<Car> listaAutoInVendita) {
        this.nome = nome;
        this.address = address;
        this.listaAutoInVendita = listaAutoInVendita;
    }

    public String getNome() {
        return nome;
    }

    public String getAddress() {
        return address;
    }

    public List<Car> getListaAutoInVendita() {
        return listaAutoInVendita;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Methods
    public void addCar(Car car) {
        this.listaAutoInVendita.add(car);
    }
    public double getPriceAverage() {
        double sum = 0;
        for (Car car : this.listaAutoInVendita) {
            sum += car.getPrice();
        }
        return sum / this.listaAutoInVendita.size();
    }


    @Override
    public String toString() {
        return "Concessionaria{" +
                "Nome: '" + nome + '\'' + "\n"+
                "Address: '" + address + '\'' + "\n"+
                "ListaAutoInVendita: \n" + listaAutoInVendita +
                '}';
    }
}
