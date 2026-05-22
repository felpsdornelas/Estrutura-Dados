public class Caixa<T> implements Armazenavel <T>{

     @Override
     public void guardar(T item) {
          System.out.println("Guardando " + item);
     }

     @Override
     public void recuperar(T item) {
          System.out.println("Recuperando " + item);
     }
}

