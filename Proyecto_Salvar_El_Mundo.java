
import java.util.Arrays;
import java.util.Scanner;


// El programa va enfocado a la ODS 14 que pretende proteger los ecosistemas marinos y costeros, reduciendo la contaminación marina y 
// la acidificación de los océanos, poner fin a prácticas insostenibles e ilegales de pesca, promover la investigación 
// científica en materia de tecnología marina, fomentar el crecimiento de los estados insulares en desarrollo y pescadores 
// artesanales e impulsar y reforzar el derecho internacional relativo a océanos y mares.
// En este caso particular se pretende realizar un seguimiento a las Tortugas encontadas y ademas de eso analizar, promedio
//de huevos, media de huevos eclosionados, mediana de torutgas que sobreviven.
//Si logramos la conciencia del uso de herramientas tecnologicas que nos permitan con una optimizacion de este tener el control de infomarciona
//a primera mano y con ello identificar todos los lugares de avistamiento.

public class Tortugas1 {
    //Base de Datos de tortuga encontrada anteriormente, con el ingreso de datos se ira alimentando esta informacion ingresada 
    //en el codigo manualmente
    
    static Scanner scanner = new Scanner(System.in);
    static String[] especies = {"Laúd", "Verde", "Boba", "Carey", "Olivácea", "De Kemp", "De Espalda Plana"};
    static int[] cantidadHuevos = {100, 123, 4, 250, 150, 110, 78};
    static int[] huevosEclosionados = {90, 83, 2, 156, 115, 90, 60};
    static double[] porcentajeHembras = {0.90, 0.90, 0.90, 0.90, 0.90, 0.90, 0.90};
    static boolean[] esAguaSalada = {true, true, true, true, true, true, true, false, true}; 
    static String[] Lugar = {"Playa" , "blanca", "meami beach","cordoba", "haiti","londres","jamaica"};

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    ingresarTortugaEncontrada(); //metodo para ingresar tortuga encontradas
                    break;
                case 2:
                    listarTortugasEncontradas();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("***** Menú *****");
        System.out.println("1. Ingresar datos de tortuga encontrada");
        System.out.println("2. Mostrar resultados");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    static void ingresarTortugaEncontrada() {
        System.out.print("Especie de la tortuga encontrada ");
        System.out.print("Sino sabe el dato, indique una descripcion: ");
        String nuevaEspecie = scanner.nextLine();

        System.out.print("Cantidad de huevos de la tortuga encontrada ");
        System.out.print("(No toque los huevos:) ");
        int nuevosHuevos = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Cantidad de huevos eclosionados de la tortuga encontrada: ");
        int nuevosHuevosEclosionados = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Porcentaje de hembras de la tortuga encontrada (0 a 1): ");
        double nuevoPorcentajeHembras = scanner.nextDouble();
        scanner.nextLine();  

        System.out.print("¿Es de agua salada? (true/false): ");
        boolean nuevoEsAguaSalada = scanner.nextBoolean();
        scanner.nextLine();  
        
        System.out.print("Lugar donde se encontro: ");
        String nuevoLugar = scanner.nextLine();

        // Agregar los nuevos datos a los arreglos
        especies = Arrays.copyOf(especies, especies.length + 1);
        cantidadHuevos = Arrays.copyOf(cantidadHuevos, cantidadHuevos.length + 1);
        huevosEclosionados = Arrays.copyOf(huevosEclosionados, huevosEclosionados.length + 1);
        porcentajeHembras = Arrays.copyOf(porcentajeHembras, porcentajeHembras.length + 1);
        esAguaSalada = Arrays.copyOf(esAguaSalada, esAguaSalada.length + 1);
        Lugar = Arrays.copyOf(Lugar, Lugar.length + 1);

        especies[especies.length - 1] = nuevaEspecie;
        cantidadHuevos[cantidadHuevos.length - 1] = nuevosHuevos;
        huevosEclosionados[huevosEclosionados.length - 1] = nuevosHuevosEclosionados;
        porcentajeHembras[porcentajeHembras.length - 1] = nuevoPorcentajeHembras;
        esAguaSalada[esAguaSalada.length - 1] = nuevoEsAguaSalada;
        Lugar[Lugar.length - 1] = nuevoLugar;
        

        System.out.println("Datos de tortuga encontrada registrados exitosamente.");
    }

    static void listarTortugasEncontradas() {
        
      
        System.out.println("----- Tortugas Encontradas -----");
        for (int i = 0; i < especies.length; i++) {
            System.out.println("Especie: " + especies[i]);
            System.out.println("Cantidad de huevos: " + cantidadHuevos[i]);
            System.out.println("Huevos eclosionados: " + huevosEclosionados[i]);
            System.out.println("Porcentaje de hembras: " + porcentajeHembras[i]);
            System.out.println("Es de agua salada: " + esAguaSalada[i]);
            System.out.println("Lugar: " + Lugar[i]);
            System.out.println();
            
        }
        
       


        // Calcular promedio de huevos
        int totalHuevos = sumarArray(cantidadHuevos);
        double promedioHuevos = (double) totalHuevos / cantidadHuevos.length;

        // Calcular media de huevos eclosionados
        int totalEclosionados = sumarArray(huevosEclosionados);
        double mediaHuevosEclosionados = (double) totalEclosionados / huevosEclosionados.length;

        // Calcular mediana de tortugas que sobreviven
        Arrays.sort(cantidadHuevos);
        int medianaTortugasquelleganalmar = cantidadHuevos[cantidadHuevos.length / 2];
        
        // Calcular cantidad de sobrevivientes
        double  cantidadSobrevivientes = (double) cantidadHuevos.length / 3;

    

        // Encontrar especie moda
        String especieModa = encontrarModa(especies);
        
   
        System.out.println("*********RESUMEN*****");
        System.out.println("Datos generales sobre las  tortugas .");  
        System.out.println("Promedio de Huevos: " + promedioHuevos);
        System.out.println("Media de Huevos Eclosionados: " + mediaHuevosEclosionados);
        System.out.println("Mediana de Tortugas que llegan al mar: " + medianaTortugasquelleganalmar);
        System.out.println("Cantidad de Sobrevivientes: " + cantidadSobrevivientes);
        System.out.println("Especie Moda: " + especieModa);
        System.out.println();
        
        
    }

    public static int sumarArray(int[] arr) {
        int total = 0;
        for (int elemento : arr) {
            total += elemento;
        }
        return total;
    }

    public static String encontrarModa(String[] arr) {
        Arrays.sort(arr);

        String moda = null;
        int maxConteo = 0;
        int conteo = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                conteo++;
            } else {
                if (conteo > maxConteo) {
                    moda = arr[i - 1];
                    maxConteo = conteo;
                }
                conteo = 1;
            }
        }

        if (conteo > maxConteo) {
            moda = arr[arr.length - 1];
        }

        return moda;
        }
     
             }

