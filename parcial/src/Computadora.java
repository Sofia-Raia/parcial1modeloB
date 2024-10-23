import java.util.Scanner;

public class Computadora {
    static Scanner sc = new Scanner(System.in);

    //1)
    private String marca;
    private String modelo;
    private long codigoBarras;
    private double precioTotal;
    private double porcentajeAumento;
    private double montoFinal;
    private String[][] componentes;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponentes(String[][] componentes) {
        this.componentes = componentes;
    }

    //-------------------------------------------------------------------------
    //long l = 12345L;
    // String str = Long.toString(l);
//c) cabecera de la tabla
    public void crearMatriz(int tam) {
        componentes = new String[tam][4];
        ////////// En la 1° van los nombres de la tabla
//        componentes[0][0] = "Codigo componente";
//        componentes[0][1] = "Denominacion";
//        componentes[0][2] = "Precio componente";
//        componentes[0][3] = "Es obligatorio";

//c)Hasta acá es el punto c.
// d)
        boolean seguir = true;


        System.out.println("Componentes de la Computadora");//1

        int componentesAgregados = 0;
        do {
            System.out.println("Ingrese el codigo (ej AAA)");//2
            String codigo = sc.nextLine().toUpperCase();
            String[] componenteEncontrado = null;
            for (int i = 0; i < GeneraPC.componentesPc.length; i++) {
                if (codigo.equalsIgnoreCase(GeneraPC.componentesPc[i][0])) { ///valido que sea componente
                    componenteEncontrado = GeneraPC.componentesPc[i];

                    break;
                }
            }
            if (componenteEncontrado == null) {
                System.out.println("El código ingresado es incorrecto");
                continue;
            }

            boolean componenteYaAgregado = false;
            for (int i = 0; i < tam; i++) {
                if (codigo.equalsIgnoreCase(this.componentes[i][0])) {
                    componenteYaAgregado = true;
                    break;
                }
            }
            if (componenteYaAgregado) {
                System.out.println("El componente ya fue agregado anteriormente");
                continue;
            }

            this.componentes[componentesAgregados] = componenteEncontrado;
            System.out.println("Se ha agregado exitosamente el componente: "+this.componentes[componentesAgregados][0]);
            componentesAgregados++;
        } while (componentesAgregados != tam);



        double precioComponente;
        double precioComponentesTotal=0;
        double recargo=0;
        int cont =0;
        //e)debo revisar que los 5 componentes obligatorios esten
        for(int i = 0; i < componentes.length; i++) {
            //Parseo de String a double
            componentes[i][2].replaceAll("[^0-9.]", "");
            precioComponente = Double.parseDouble(componentes[i][2]);
            precioComponentesTotal+=precioComponente;

            if (componentes[i][3].equalsIgnoreCase("s")) {
                cont++;
            }

        }
        if (cont < 5) {
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("ATENCIÓN, 1 o más de los componentes obligatorios no fueron agregados");
            System.out.println("Por este motivo se cobrara un recargo del 20%");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("");
            //f)calculo el recargo
            recargo= precioComponentesTotal * 0.20;

        }
        //MUESTRO LA COMPRA
        System.out.println("");
        System.out.println("#####################################");
        System.out.println("_______LA COMPUTADORA ES: _____ ");
        System.out.println("#####################################");
        System.out.println("MARCA ------"+marca );
        System.out.println("MODELO -----"+modelo );
        System.out.println("CODIGO DE BARRAS --"+codigoBarras );
        System.out.println("CODIGO ÍTEM | DENNOMINACIÓN | PRECIO");
        for (int i = 0; i < componentes.length; i++) { //filas
            for (int j = 0; j < componentes[i].length-1; j++) { //col
                System.out.print(componentes[i][j]+"     | ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Total de componentes: $"+precioComponentesTotal);
        if(recargo!=0){
            System.out.println("Recargo del %20: $"+recargo);
        }
        System.out.println("MONTO FINAL: $"+(precioComponentesTotal+recargo));
    }
}







