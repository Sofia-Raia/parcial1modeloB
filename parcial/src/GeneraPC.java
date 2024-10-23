import java.util.Scanner;

public class GeneraPC {
    //variable de clase porque tien la palabra static
     static public String[][] componentesPc = {
            {"AAA", "Placa Madre", "20000", "S"},
            {"BBB", "Procesador", "25000", "S"},
            {"CCC", "Memoria RAM", "5000", "S"},
            {"DDD", "Placa de Red", "3000", "N"},
            {"EEE", "Disco Rigido SSD", "22000", "S"},
            {"FFF", " Placa de Video", "42000", "N"},
            {"GGG", "Monitor Led 21", "32000", "N"},
            {"HHH", "Monitor Led 25", "41000", "N"},
            {"JJJ", "KitTeclado - Mouse", "9000", "N"},
            {"KKK", "Gabinete", "6500", "S"},
            {"LLL", "FuenteAlimentación", "6500", "S"},
            {"MMM", "Placa de Sonido", "16500", "N"}
     };



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

// A) Se ingresa marca, modelo, codigo de barra y cant de compoentes.

        Computadora c = new Computadora();
        System.out.println("Ingrese nombre de la marca");
        String marca = sc.nextLine();
        c.setMarca(marca);

        System.out.println("Ingrese el nombre del modelo");
        String modelo = sc.nextLine();
        c.setModelo(modelo);

        boolean continuar = true;

        //codigo
        do {
            System.out.println("Ingrese el N° de codigo de barras");
            System.out.println("Debe contener entre 7 y 15 caracteres...");
            String codBarras = sc.nextLine();
            if (codBarras.length() >= 7 && codBarras.length() <= 15) {
                Long cod=Long.parseLong(codBarras);
                c.setCodigoBarras(cod);
                continuar = false;

            } else {
                System.out.println("Debe contener entre 7 y 15 caracteres..");
            }

        } while (continuar);

        //b) componentes
        boolean continuar2 = true;
        do {
            System.out.println("Indique la cantidad de componentes de la computadora");
            System.out.println("El n° debe ser 5 a 12");
             int cantComponentes = sc.nextInt();

            if (cantComponentes >= 5 && cantComponentes <= 12) {
                c.crearMatriz(cantComponentes);                  ///Acá se manda el tam de la matriz
                continuar2 = false;
            } else {
                System.out.println("Debe contener de 5 a 12 componentes..Intente nuevamente");
            }

        } while (continuar2);



    }

}